package io.acari.alphaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableBinding(Sink.class)
public class AlphaClientApplication {
    public static final String SERVICE_NAME = "alpha-client";

    public static void main(String[] args) {
        SpringApplication.run(AlphaClientApplication.class, args);
    }
}