package com.cuijing.pbac.start;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

import static java.time.ZoneId.of;
import static java.util.TimeZone.getTimeZone;

/**
 * @author CuiJIng
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class,scanBasePackages = {"com.cuijing"})
@EnableTransactionManagement
@EnableCaching(proxyTargetClass = true)
@EntityScan("com.cuijing.pbac.persistence")
@EnableJpaRepositories(basePackages = {"com.cuijing.pbac.persistence"})
public class PbacStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(PbacStartApplication.class, args);
    }
    @PostConstruct
    void started() {
        TimeZone.setDefault(getTimeZone(of("Asia/Shanghai")));
    }

}
