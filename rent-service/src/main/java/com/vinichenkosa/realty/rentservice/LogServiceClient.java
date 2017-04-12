package com.vinichenkosa.realty.rentservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("log-service")
public interface LogServiceClient {

    @RequestMapping(path = "/log", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity log(Integer count);

}
