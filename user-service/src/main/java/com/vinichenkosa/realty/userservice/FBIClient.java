package com.vinichenkosa.realty.userservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "test-service")
public interface FBIClient {

    @RequestMapping(
            path = "/fink",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    )
    void fink(Fink req);

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Fink {
        private int hippoCount;
        private int parrotFee;
    }
}
