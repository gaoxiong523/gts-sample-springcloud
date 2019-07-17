package com.taobao.txc.sample;

import com.alibaba.druid.pool.DruidDataSource;

import com.taobao.txc.datasource.cobar.TxcDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Primary
    @Bean("dataSourceProxy")
    public TxcDataSource dataSourceProxy(DruidDataSource dataSource) {
        return new TxcDataSource(dataSource);
    }

    @Bean("jdbcTemplate")
    @ConditionalOnBean(TxcDataSource.class)
    public JdbcTemplate jdbcTemplate(TxcDataSource dataSourceProxy) {
        return new JdbcTemplate(dataSourceProxy);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
