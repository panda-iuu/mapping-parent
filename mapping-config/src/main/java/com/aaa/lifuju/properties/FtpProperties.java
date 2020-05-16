package com.aaa.lifuju.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju.properties
 * @ClassName: FtpProperties
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/15 9:07
 * @Version: 1.0
 */
@Component
@PropertySource("classpath:properties/ftp.properties")
@ConfigurationProperties(prefix = "spring.ftp")
@Data
public class FtpProperties {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String basePath;
    private String httpPath;
}
