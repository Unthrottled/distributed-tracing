package io.acari.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@EnableDiscoveryClient
@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}

@RestController
class Resto{
	@RequestMapping("/")
	public Properties getProp(){
		return System.getProperties();
	}
}