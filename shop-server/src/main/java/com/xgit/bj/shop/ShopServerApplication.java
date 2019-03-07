package com.xgit.bj.shop;

import com.xgit.bj.eureka.EurekaDeregister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaServiceRegistry;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShopServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopServerApplication.class, args);
    }

    @Bean(initMethod = "showDeregisterInfo", destroyMethod = "deregister")
    public EurekaDeregister eurekaDeregister(EurekaRegistration registration, EurekaServiceRegistry serviceRegistry, EurekaClientConfigBean eurekaClientConfigBean) {
        return new EurekaDeregister(registration, serviceRegistry, eurekaClientConfigBean);
    }
}
