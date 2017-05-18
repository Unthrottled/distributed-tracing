package io.acari.service.charlie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
class RestEndpoint {

    private MessagingSource messagingSource;
    private ZuluRestClient zuluRestClient;

    @Autowired
    public RestEndpoint(MessagingSource messagingSource, ZuluRestClient zuluRestClient) {
        this.messagingSource = messagingSource;
        this.zuluRestClient = zuluRestClient;
    }

    @RequestMapping("/")
    public ResponseEntity<String> get() {
        String zuluMessage = zuluRestClient.fetchMessageYo();
        String charlieMessage = "Hello from Charlie Service @ " + Instant.now() + " and " + zuluMessage;
        messagingSource.sendMessage(charlieMessage);
        return ResponseEntity.ok(charlieMessage);
    }
}