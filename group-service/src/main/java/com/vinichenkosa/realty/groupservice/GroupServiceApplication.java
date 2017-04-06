package com.vinichenkosa.realty.groupservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@SpringBootApplication
@RestController
public class GroupServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroupServiceApplication.class, args);
    }
    
    @RequestMapping(
                path = "/fee",
                method = RequestMethod.GET,
//                consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public HashMap fee() {
        HashMap<String, Long> response = new HashMap<>();
        response.put("parrot_fee", ThreadLocalRandom.current().nextLong(100));
        return response;
    }
}