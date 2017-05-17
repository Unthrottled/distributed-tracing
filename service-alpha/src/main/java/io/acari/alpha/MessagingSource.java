package io.acari.alpha;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
interface MessagingSource {
    @Gateway(requestChannel = Source.OUTPUT)
    void sendMessage(String message);
}
