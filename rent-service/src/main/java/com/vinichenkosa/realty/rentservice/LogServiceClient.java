package com.vinichenkosa.realty.rentservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient("log-service")
public interface LogServiceClient {

    @RequestMapping(path = "/log", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity log(LogRequest count);

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class LogRequest {
        String message;
        Date date;
    }
}
