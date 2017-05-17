package io.acari.service.charlie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCharlie {

    public static final String ZULU_NAME = "service-zulu";

    public static void main(String[] args) {
        SpringApplication.run(ServiceCharlie.class, args);
    }

}