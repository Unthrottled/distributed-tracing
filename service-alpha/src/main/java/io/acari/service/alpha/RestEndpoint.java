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
import java.util.concurrent.Future;

@RestController
class RestEndpoint {

    private DiscoveryClient discoStu;
    private MessagingSource messagingSource;
    private BravoRestClient bravoRestClient;
    private CharlieRestClient charlieRestClient;
    private PoorMansExecutor poorMansExecutor;

    @Autowired
    public RestEndpoint(DiscoveryClient discoStu, MessagingSource messagingSource,
                        BravoRestClient bravoRestClient, CharlieRestClient charlieRestClient, PoorMansExecutor poorMansExecutor) {
        this.discoStu = discoStu;
        this.messagingSource = messagingSource;
        this.bravoRestClient = bravoRestClient;
        this.charlieRestClient = charlieRestClient;
        this.poorMansExecutor = poorMansExecutor;
    }

    @RequestMapping("/")
    public ResponseEntity<String> get() throws Exception {
        List<String> services = discoStu.getServices();
        Future<String> bravoMessage = poorMansExecutor.submit(bravoRestClient::fetchMessageYo);
        Future<String> charlieMessage = poorMansExecutor.submit(charlieRestClient::fetchMessageYo);
        String bravoFetchedMethod = bravoMessage.get();
        String fetchedCharlieMethod = charlieMessage.get();
        String message = services + " @ " + Instant.now() + bravoFetchedMethod + fetchedCharlieMethod;
        messagingSource.sendMessage("Alpha Stream Sending " + message);
        return ResponseEntity.ok("Alpha REST Sending " + message);
    }
}