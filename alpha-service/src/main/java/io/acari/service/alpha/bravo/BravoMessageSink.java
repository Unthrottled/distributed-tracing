package io.acari.service.alpha.bravo;

import io.acari.service.alpha.MessagingSource;
import io.acari.service.alpha.charlie.CharlieMessageSink;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class BravoMessageSink {
    private static final Log log = LogFactory.getLog(CharlieMessageSink.class);
    private MessagingSource messagingSource;

    @Autowired
    public BravoMessageSink(MessagingSource messagingSource) {
        this.messagingSource = messagingSource;
    }

    @ServiceActivator(inputChannel = BravoSink.INPUT)
    public void acceptMessage(String message) {
        log.info("Alpha Service, Bravo Stream Sink got message: " + message);
        this.messagingSource.sendMessage(message);
    }
}
