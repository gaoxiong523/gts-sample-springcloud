package com.taobao.txc.sample;

import com.taobao.txc.datasource.cobar.TxcDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    // Note: 样例使用 MybatisAutoConfiguration 机制来自动生成 Mybatis 配置。
    // 因为 MybatisAutoConfiguration 定义了条件 @ConditionalOnSingleCandidate(DataSource.class)
    // 所以，这里只能定义一个 DataSource Bean 。
    // 这只是样例的用法，不是 GTS 的限制。

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public TxcDataSource dataSource() {
        return new TxcDataSource();
    }

}
