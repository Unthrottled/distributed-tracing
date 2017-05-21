package io.acari.service.alpha;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

@FeignClient(serviceId = AlphaService.BRAVO_NAME)
public interface BravoRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/bravo", consumes = MediaType.APPLICATION_JSON)
    String fetchMessageYo();
}

