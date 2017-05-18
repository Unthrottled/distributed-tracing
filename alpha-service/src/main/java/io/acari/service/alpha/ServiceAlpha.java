package io.acari.service.alpha;

import io.acari.service.alpha.bravo.BravoSink;
import io.acari.service.alpha.charlie.CharlieSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({Source.class, BravoSink.class, CharlieSink.class})
public class ServiceAlpha {
    public static final String BRAVO_NAME = "service-bravo";
    public static final String CHARLIE_NAME = "service-charlie";

    public static void main(String[] args) {
        SpringApplication.run(ServiceAlpha.class, args);
    }
}
