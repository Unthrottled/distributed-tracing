package io.acari.service.alpha.charlie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class CharlieMessageSink {
    Log log = LogFactory.getLog(CharlieMessageSink.class);

    @ServiceActivator(inputChannel = CharlieSink.INPUT)
    public void acceptMessage(String message){
        this.log.info("Got message: " + message);
    }
}
