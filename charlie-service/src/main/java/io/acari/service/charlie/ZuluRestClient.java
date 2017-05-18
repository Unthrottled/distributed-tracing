package io.acari.service.charlie;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;

@FeignClient(serviceId = CharlieService.ZULU_NAME)
interface ZuluRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/", consumes = MediaType.APPLICATION_JSON)
    String fetchMessageYo();
}