package io.acari.alphaclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class MessageSink {
    private static final Log log = LogFactory.getLog(MessageSink.class);

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void acceptMessage(String message) {
        log.info("Alpha Client, Alpha Stream Sink got message: " + message);
    }
}
