package io.acari.service.bravo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
class RestEndpoint {

    @RequestMapping("/bravo")
    public ResponseEntity<String> get() {
        String message = "Hello from Bravo Service @ " + Instant.now();
        return ResponseEntity.ok(message);
    }
}