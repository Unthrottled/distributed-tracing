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
    //TODO: add http:// thing for zipkin log
    private MessagingSource messagingSource;
    private BravoRestClient bravoRestClient;
    private CharlieRestClient charlieRestClient;
    private PoorMansExecutor poorMansExecutor;

    @Autowired
    public RestEndpoint(MessagingSource messagingSource,
                        BravoRestClient bravoRestClient, CharlieRestClient charlieRestClient, PoorMansExecutor poorMansExecutor) {
        this.messagingSource = messagingSource;
        this.bravoRestClient = bravoRestClient;
        this.charlieRestClient = charlieRestClient;
        this.poorMansExecutor = poorMansExecutor;
    }

    @RequestMapping("/")
    public ResponseEntity<String> get() throws Exception {
        Future<String> bravoMessage = poorMansExecutor.submit(bravoRestClient::fetchMessageYo);
        Future<String> charlieMessage = poorMansExecutor.submit(charlieRestClient::fetchMessageYo);
        String bravoFetchedMethod = bravoMessage.get();
        String fetchedCharlieMethod = charlieMessage.get();
        String alphaMessage = "Hello from Alpha Service @ " + Instant.now() +
                " and " + bravoFetchedMethod + " and " + fetchedCharlieMethod;
        messagingSource.sendMessage(alphaMessage);
        return ResponseEntity.ok(alphaMessage);
    }
}