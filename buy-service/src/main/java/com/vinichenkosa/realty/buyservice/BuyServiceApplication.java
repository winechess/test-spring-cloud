package com.vinichenkosa.realty.buyservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@EnableCircuitBreaker
public class BuyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyServiceApplication.class, args);
    }

    @RequestMapping(path = "/buy", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity buy(@RequestParam(name = "count", defaultValue = "0") Integer count) {
        log.debug("buy invoked");
        return ResponseEntity.ok(count);
    }

}
