package io.acari.service.zulu;

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

    @Autowired
    public RestEndpoint(MessagingSource messagingSource) {
        this.messagingSource = messagingSource;
    }

    @RequestMapping("/")
    public ResponseEntity<String> get() {
        String messageToSend = "Hello from Zulu Service @ " + Instant.now();
        messagingSource.sendMessage(messageToSend);
        return ResponseEntity.ok(messageToSend);
    }
}