package com.gaoxiong.seata.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoxiong
 * @ClassName DruidProperties
 * @Description TODO
 * @date 2019/9/27 9:55
 */
@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
@Configuration
public class DruidProperties {
    private int initialSize;
    private int minIdle;
    private int maxActive;
    private int maxWait;
    private boolean poolPreparedStatements;
}
