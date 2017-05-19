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
    private BravoRestClient bravoRestClient;
    private CharlieRestClient charlieRestClient;
    private PoorMansExecutor poorMansExecutor;

    @Autowired
    public RestEndpoint(BravoRestClient bravoRestClient, CharlieRestClient charlieRestClient, PoorMansExecutor poorMansExecutor) {
        this.bravoRestClient = bravoRestClient;
        this.charlieRestClient = charlieRestClient;
        this.poorMansExecutor = poorMansExecutor;
    }

    @RequestMapping("/alpha")
    public ResponseEntity<String> get() throws Exception {
        Future<String> bravoMessage = poorMansExecutor.submit(bravoRestClient::fetchMessageYo);
        Future<String> charlieMessage = poorMansExecutor.submit(charlieRestClient::fetchMessageYo);
        String bravoFetchedMethod = bravoMessage.get();
        String fetchedCharlieMethod = charlieMessage.get();
        String alphaMessage = "Hello from Alpha Service @ " + Instant.now() +
                " and " + bravoFetchedMethod + " and " + fetchedCharlieMethod;
        return ResponseEntity.ok(alphaMessage);
    }
}