package io.acari.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class BravoMessageSink {
    Log log = LogFactory.getLog(CharlieMessageSink.class);

    @ServiceActivator(inputChannel = BravoSink.INPUT)
    public void acceptMessage(String message) {
        this.log.info("Got message: " + message);
    }
}
