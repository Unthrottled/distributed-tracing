package io.acari.service.charlie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
class MessageSink {
	Log log = LogFactory.getLog(MessageSink.class);

	@ServiceActivator(inputChannel = Sink.INPUT)
	public void acceptMessage(String message){
		this.log.info("Got message: " + message);
	}
}

