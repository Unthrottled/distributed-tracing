package io.acari.service.charlie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
class RestEndpoint {

    private ZuluRestClient zuluRestClient;

    @Autowired
    public RestEndpoint(ZuluRestClient zuluRestClient) {
        this.zuluRestClient = zuluRestClient;
    }

    @RequestMapping("/charlie")
    public ResponseEntity<String> get() {
        String zuluMessage = zuluRestClient.fetchMessageYo();
        String charlieMessage = "Hello from Charlie Service @ " + Instant.now() + " and " + zuluMessage;
        return ResponseEntity.ok(charlieMessage);
    }
}