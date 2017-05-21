package io.acari.service.charlie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CharlieService {

    public static final String ZULU_NAME = "zulu-service";

    public static void main(String[] args) {
        SpringApplication.run(CharlieService.class, args);
    }

}
