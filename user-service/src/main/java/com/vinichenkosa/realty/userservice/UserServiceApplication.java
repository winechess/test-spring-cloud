package com.vinichenkosa.realty.userservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class UserServiceApplication {

    private AtomicLong hippoCount = new AtomicLong(Long.MAX_VALUE);

    @Autowired
    private TestClient testClient;
    @Autowired
    private GroupClient groupClient;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


    @RequestMapping(
            path = "/rent",
            method = RequestMethod.GET
//                consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public HashMap rent(@RequestParam Optional<Integer> count) throws MalformedURLException {

        int fee = 0;

        try {
            fee = groupClient.fee().getParrotFee();
        } finally {
            testClient.fink(
                    TestClient.Fink.builder()
                            .hippoCount(count.orElse(1))
                            .parrotFee(fee)
                            .build());
        }

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("hippo_remain", hippoCount.addAndGet(-1L * count.orElse(1)));
        hashMap.put("parrot_fee", fee);
        return hashMap;
    }
}

