package io.acari.service.alpha.bravo;

import io.acari.service.alpha.ServiceAlpha;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

@FeignClient(serviceId = ServiceAlpha.BRAVO_NAME)
interface BravoRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/", consumes = MediaType.APPLICATION_JSON)
    String fetchMessageYo();
}

