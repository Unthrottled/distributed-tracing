package io.acari.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCharlie {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCharlie.class, args);
    }

}