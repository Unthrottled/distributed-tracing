package io.acari.service.charlie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
class MessageSink {
    Log log = LogFactory.getLog(MessageSink.class);
    private MessagingSource messagingSource;

    @Autowired
    MessageSink(MessagingSource messagingSource) {
        this.messagingSource = messagingSource;
    }


    @ServiceActivator(inputChannel = Sink.INPUT)
    public void acceptMessage(String message) {
        String messageToSend = "Zulu Stream on Charlie Service got message: " + message;
        this.log.info(messageToSend);
        this.messagingSource.sendMessage(messageToSend);
    }
}

