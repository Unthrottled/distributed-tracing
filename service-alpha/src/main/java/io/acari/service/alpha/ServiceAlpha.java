package io.acari.service.alpha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Source.class)
public class ServiceAlpha {
    private static final Logger log = LoggerFactory.getLogger(ServiceAlpha.class);
    public static final String BRAVO_NAME = "service-bravo";
    public static final String CHARLIE_NAME = "service-charlie";

    public static void main(String[] args) {
        SpringApplication.run(ServiceAlpha.class, args);
    }
}
