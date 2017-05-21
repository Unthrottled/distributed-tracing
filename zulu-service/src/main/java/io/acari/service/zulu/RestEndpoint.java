package io.acari.service.zulu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
class RestEndpoint {


    @RequestMapping("/zulu")
    public ResponseEntity<String> get() {
        String messageToSend = "Hello from Zulu Service @ " + Instant.now();
        return ResponseEntity.ok(messageToSend);
    }
}