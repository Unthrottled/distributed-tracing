package io.acari.service.alpha;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessagingSource {
    @Gateway(requestChannel = Source.OUTPUT)
    void sendMessage(String message);
}
