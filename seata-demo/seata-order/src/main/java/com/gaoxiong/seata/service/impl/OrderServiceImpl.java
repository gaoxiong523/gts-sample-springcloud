package com.gaoxiong.seata.service.impl;

import com.gaoxiong.seata.feign.AccountFeignClient;
import com.gaoxiong.seata.pojo.Order;
import com.gaoxiong.seata.repository.OrderRepository;
import com.gaoxiong.seata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author gaoxiong
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @date 2019/9/25 16:32
 */
@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Override
    public void create ( String userId, String commodityCode, Integer count ) {
        //1.本地处理
        //计算订单价格
        BigDecimal money = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order();
        order.setCommodityCode(commodityCode);
        order.setMoney(money.intValue());
        order.setUserId(userId);
        order.setCount(count);
        orderRepository.save(order);

        //账户记账扣钱
        accountFeignClient.debit(userId, money);

    }
}
