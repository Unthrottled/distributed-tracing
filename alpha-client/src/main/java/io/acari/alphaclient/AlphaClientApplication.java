package io.acari.alphaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class AlphaClientApplication {
    public static final String SERVICE_NAME = "alpha-service";

    public static void main(String[] args) {
        SpringApplication.run(AlphaClientApplication.class, args);
    }
}