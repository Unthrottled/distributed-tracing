package io.acari.service.alpha.charlie;

import io.acari.service.alpha.MessagingSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class CharlieMessageSink {
    private static final Log log = LogFactory.getLog(CharlieMessageSink.class);

    private MessagingSource messagingSource;

    @Autowired
    public CharlieMessageSink(MessagingSource messagingSource) {
        this.messagingSource = messagingSource;
    }

    @ServiceActivator(inputChannel = CharlieSink.INPUT)
    public void acceptMessage(String message) {
        log.info("Alpha Service, Charlie Stream Sink got message: " + message);
        this.messagingSource.sendMessage(message);
    }
}
