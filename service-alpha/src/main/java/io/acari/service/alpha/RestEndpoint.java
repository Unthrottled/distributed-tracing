package io.acari.service.alpha;

import io.acari.service.alpha.bravo.BravoRestClient;
import io.acari.service.alpha.charlie.CharlieRestClient;
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
    private BravoRestClient bravoRestClient;
    private CharlieRestClient charlieRestClient;

    @Autowired
    public RestEndpoint(DiscoveryClient discoStu, MessagingSource messagingSource,
                        BravoRestClient bravoRestClient, CharlieRestClient charlieRestClient) {
        this.discoStu = discoStu;
        this.messagingSource = messagingSource;
        this.bravoRestClient = bravoRestClient;
        this.charlieRestClient = charlieRestClient;
    }

    @RequestMapping("/")
    public ResponseEntity<String> get() {
        List<String> services = discoStu.getServices();
        String bravoMessage = bravoRestClient.fetchMessageYo();
        String charlieMessage = charlieRestClient.fetchMessageYo();
        String message = services + " @ " + Instant.now() + bravoMessage + charlieMessage;
        messagingSource.sendMessage("Alpha Stream Sending " + message);
        return ResponseEntity.ok("Alpha REST Sending " + message);
    }
}