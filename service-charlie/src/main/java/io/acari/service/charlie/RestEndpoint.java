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

    private DiscoveryClient discoStu;
    private MessagingSource messagingSource;
    private ZuluRestClient zuluRestClient;

    @Autowired
    public RestEndpoint(DiscoveryClient discoStu, MessagingSource messagingSource, ZuluRestClient zuluRestClient) {
        this.discoStu = discoStu;
        this.messagingSource = messagingSource;
        this.zuluRestClient = zuluRestClient;
    }

    @RequestMapping("/")
    public ResponseEntity<String> get() {
        List<String> services = discoStu.getServices();
        String zuluMessage = zuluRestClient.fetchMessageYo();
        String message = services + " @ " + Instant.now() + " " + zuluMessage;
        messagingSource.sendMessage("Charlie Stream Sending " + message);
        return ResponseEntity.ok("Charlie REST Sending " + message);
    }
}