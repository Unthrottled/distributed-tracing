package io.acari.service.alpha.charlie;

import io.acari.service.alpha.AlphaService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

@FeignClient(serviceId = AlphaService.CHARLIE_NAME)
public interface CharlieRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/charlie", consumes = MediaType.APPLICATION_JSON)
    String fetchMessageYo();
}