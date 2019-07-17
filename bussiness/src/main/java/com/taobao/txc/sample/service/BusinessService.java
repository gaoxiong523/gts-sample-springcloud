package com.taobao.txc.sample.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import com.taobao.txc.client.aop.annotation.TxcTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * The type Business service.
 *
 * @author jimin.jm @alibaba-inc.com
 * @date 2019 /06/14
 */
@Service
public class BusinessService {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 减库存，下订单
     *
     * @param userId        the user id
     * @param commodityCode the commodity code
     * @param orderCount    the order count
     */
    @TxcTransaction
    public void purchase(String userId, String commodityCode, int orderCount, boolean rollback) {
        String result = restTemplate.getForObject(
            "http://127.0.0.1:8081/deduct/" + commodityCode + "/" + orderCount,
            String.class);
        if (!SUCCESS.equals(result)) {
            throw new RuntimeException("storage return fail");
        }
        String url = "http://127.0.0.1:8082/order";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("userId", userId);
        map.add("commodityCode", commodityCode);
        map.add("orderCount", orderCount + "");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
            map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request,
            String.class);

        result = response.getBody();

        if (!SUCCESS.equals(result)) {
            throw new RuntimeException("order return fail");
        }

        if (!validData(userId, commodityCode)) {
            throw new RuntimeException("账户或库存不足,执行回滚");
        }

        if (rollback) {
            throw new RuntimeException("because of rollback param setting, start to rollback");
        }
    }

    /**
     * Init data.
     */
    @PostConstruct
    public void initData() {
        jdbcTemplate.update("delete from account_tbl");
        jdbcTemplate.update("delete from order_tbl");
        jdbcTemplate.update("delete from storage_tbl");
        jdbcTemplate.update("insert into account_tbl(user_id,money) values('U100000','10000') ");
        jdbcTemplate.update("insert into storage_tbl(commodity_code,count) values('C100000','200') ");
    }

    /**
     * Valid data boolean.
     *
     * @return the boolean
     */
    public boolean validData(String userId, String commodityCode) {
        Map accountMap = jdbcTemplate.queryForMap("select * from account_tbl where user_id='" + userId + "'");
        if (Integer.parseInt(accountMap.get("money").toString()) < 0) {
            return false;
        }
        Map storageMap = jdbcTemplate.queryForMap(
            "select * from storage_tbl where commodity_code='" + commodityCode + "'");
        if (Integer.parseInt(storageMap.get("count").toString()) < 0) {
            return false;
        }
        return true;
    }
}
