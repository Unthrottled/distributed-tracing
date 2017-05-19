package io.acari.alphaclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

@FeignClient(serviceId = AlphaClientApplication.SERVICE_NAME)
public interface AlphaRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/alpha", consumes = MediaType.APPLICATION_JSON)
    String getMessageYo();
}
