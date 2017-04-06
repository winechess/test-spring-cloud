package com.vinichenkosa.realty.testservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@SpringBootApplication
@RestController
public class TestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }

    @RequestMapping(
                path = "/fink",
                method = RequestMethod.POST,
//                consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void fink(@RequestBody HashMap<String, String> req) {
        log.info("{}", req);
    }
}