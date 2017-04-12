package com.vinichenkosa.realty.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableTurbineStream
@EnableHystrixDashboard
public class MonitoringServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitoringServerApplication.class, args);
    }
}
