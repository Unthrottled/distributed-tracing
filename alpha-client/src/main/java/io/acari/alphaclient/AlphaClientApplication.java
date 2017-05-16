package io.acari.alphaclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableBinding(Sink.class)
public class AlphaClientApplication {
	public static final String SERVICE_NAME = "service-alpha";

	public static void main(String[] args) {
		SpringApplication.run(AlphaClientApplication.class, args);
	}
}

@MessageEndpoint
class MessageSink {
	Log log = LogFactory.getLog(MessageSink.class);

	@ServiceActivator(inputChannel = Sink.INPUT)
	public void acceptMessage(String message){
		this.log.info("Got message: " + message);
	}
}

@FeignClient(serviceId = AlphaClientApplication.SERVICE_NAME)
interface RestClient {
	@RequestMapping(method = RequestMethod.GET, value = "/", consumes = MediaType.APPLICATION_JSON)
	String getMessageYo();
}

@RestController
@RequestMapping("/message")
class ClientRestController {
	private RestClient restClient;

	@Autowired
	public ClientRestController(RestClient restClient) {
		this.restClient = restClient;
	}

	@RequestMapping("/client")
	ResponseEntity<String> callService(){
		return ResponseEntity.ok(restClient.getMessageYo());
	}

}