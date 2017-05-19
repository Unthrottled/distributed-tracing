package io.acari.service.zulu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
class RestEndpoint {

    private MessagingSource messagingSource;
    private PoorMansExecutor poorMansExecutor;

    @Autowired
    public RestEndpoint(MessagingSource messagingSource, PoorMansExecutor poorMansExecutor) {
        this.messagingSource = messagingSource;
        this.poorMansExecutor = poorMansExecutor;
    }

    @RequestMapping("/zulu")
    public ResponseEntity<String> get() {
        String messageToSend = "Hello from Zulu Service @ " + Instant.now();
        poorMansExecutor.submit(()-> messagingSource.sendMessage(messageToSend));
        return ResponseEntity.ok(messageToSend);
    }
}