package io.acari.distributedtracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@MessagingGateway
interface MessagingSource {
    @Gateway(requestChannel = Source.OUTPUT)
    void sendMessage(String message);
}

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Source.class)
public class DistributedTracingApplication {
    private static final Logger log = LoggerFactory.getLogger(DistributedTracingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DistributedTracingApplication.class, args);
    }
}

@RestController
class RestGuy {

    private DiscoveryClient discoStu;
    private MessagingSource messagingSource;

    @Autowired
    public RestGuy(DiscoveryClient discoStu, MessagingSource messagingSource) {
        this.discoStu = discoStu;
        this.messagingSource = messagingSource;
    }

    @RequestMapping("/")
    public List<String> get() {
        List<String> services = discoStu.getServices();
        services.add("Piss Off.");
        messagingSource.sendMessage("Sending " + services + " @ " + Instant.now());
        return services;
    }
}
