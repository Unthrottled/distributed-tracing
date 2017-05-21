package io.acari.service.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class AlphaService {
    public static final String BRAVO_NAME = "bravo-service";
    public static final String CHARLIE_NAME = "charlie-service";

    public static void main(String[] args) {
        SpringApplication.run(AlphaService.class, args);
    }
}
