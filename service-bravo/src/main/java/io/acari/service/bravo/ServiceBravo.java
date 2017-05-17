package io.acari.service.bravo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceBravo {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBravo.class, args);
    }
}