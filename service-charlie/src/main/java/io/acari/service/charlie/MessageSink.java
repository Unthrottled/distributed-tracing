package io.acari.service.charlie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
class MessageSink {
    private static final Log log = LogFactory.getLog(MessageSink.class);
    private MessagingSource messagingSource;

    @Autowired
    MessageSink(MessagingSource messagingSource) {
        this.messagingSource = messagingSource;
    }


    @ServiceActivator(inputChannel = Sink.INPUT)
    public void acceptMessage(String message) {
        log.info("Charlie Service, Zulu Stream Sink got message: " + message);
        this.messagingSource.sendMessage(message);
    }
}

