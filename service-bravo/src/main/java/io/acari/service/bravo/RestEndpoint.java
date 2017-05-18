package io.acari.service.bravo;

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
        String message = "Hello from Bravo Service @ " + Instant.now();
        messagingSource.sendMessage(message);
        return ResponseEntity.ok(message);
    }
}