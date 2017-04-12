package com.vinichenkosa.realty.rentservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class RentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentServiceApplication.class, args);
    }

    @Autowired
    private LogServiceClient logServiceClient;

    @RequestMapping(path = "/rent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity rent(Integer count){
        logServiceClient.log(LogServiceClient.LogRequest.builder().date(new Date()).message("Rent "+count+" properties.").build());
        return ResponseEntity.ok("OK");
    }

}
