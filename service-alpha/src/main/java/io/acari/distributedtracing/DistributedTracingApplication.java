package io.acari.distributedtracing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
public class DistributedTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedTracingApplication.class, args);
	}


}

@RestController
class RestGuy {

	private DiscoveryClient discoStu;

	@Autowired
	public RestGuy(DiscoveryClient discoStu) {
		this.discoStu = discoStu;
	}

	@RequestMapping("/")
	public List<String> get(){
		List<String> services = discoStu.getServices();
		services.add("Piss Off.");
		return services;
	}
}
