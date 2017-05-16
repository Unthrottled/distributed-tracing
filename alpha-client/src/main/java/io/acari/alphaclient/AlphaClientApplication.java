package io.acari.alphaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class AlphaClientApplication {
	public static final String SERVICE_NAME = "service-alpha";

	public static void main(String[] args) {
		SpringApplication.run(AlphaClientApplication.class, args);
	}
}

@FeignClient(serviceId = AlphaClientApplication.SERVICE_NAME)
interface RestReader {
	@RequestMapping(method = RequestMethod.GET, value = "/", consumes = MediaType.APPLICATION_JSON)
	String getMessageYo();
}

@RestController
@RequestMapping("/message")
class ClientRestController {
	private RestReader restReader;

	@Autowired
	public ClientRestController(RestReader restReader) {
		this.restReader = restReader;
	}

	@RequestMapping("/client")
	ResponseEntity<String> callService(){
		return ResponseEntity.ok(restReader.getMessageYo());
	}

}