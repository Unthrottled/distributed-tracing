package io.acari.service.charlie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding({Sink.class, Source.class})
public class ServiceCharlie {

    public static final String ZULU_NAME = "service-zulu";

    public static void main(String[] args) {
        SpringApplication.run(ServiceCharlie.class, args);
    }

}
