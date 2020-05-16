package com.aaa.lifuju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: mapping-parent
 * @Package: com.aaa.lifuju
 * @ClassName: ApplicationRun7082
 * @Author: lifuju
 * @Description:
 * @Date: 2020/5/12 11:01
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7082 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7082.class,args);
    }
}
