package com.aaa.lifuju.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.properties
 * @ClassName: RedisCluterProperties
 * @Author: lifuju
 * @Description:
 *          @PropertySource这个注解的作用是加载某一个properties文件中属性的值
 * @Date: 2020/5/14 11:26
 * @Version: 1.0
 */

@Component
@PropertySource("classpath:properties/redis_cluster.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisClusterProperties {
    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;
}
