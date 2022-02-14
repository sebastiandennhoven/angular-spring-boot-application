package com.sd.usertask;

import com.sd.usertask.services.RestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class Application {

    private RestService restService;

    public Application(RestService restService) {
        this.restService = restService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
