package io.acari.distributedtracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DistributedTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedTracingApplication.class, args);
	}

	@RequestMapping("/")
	public String get(){
		return "go away. \n";
	}
}
