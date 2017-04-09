package com.vinichenkosa.realty.userservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "group-service")
public interface GroupClient {

    @RequestMapping(
            path = "/fee",
            method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    )
    Fee fee();

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Fee {
        @JsonProperty("parrot_fee")
        private int parrotFee;
    }

}
