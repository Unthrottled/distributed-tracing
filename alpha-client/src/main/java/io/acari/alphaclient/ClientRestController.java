package io.acari.alphaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
class ClientRestController {
    private AlphaRestClient alphaRestClient;

    @Autowired
    public ClientRestController(AlphaRestClient alphaRestClient) {
        this.alphaRestClient = alphaRestClient;
    }

    @RequestMapping("/message")
    ResponseEntity<String> callService(){
        return ResponseEntity.ok(alphaRestClient.getMessageYo());
    }

}
