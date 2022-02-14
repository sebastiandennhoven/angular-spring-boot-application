package com.sd.usertask.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; 
import java.time.Duration;
import java.util.*;

import com.sd.usertask.models.ApiResponse;
import com.sd.usertask.models.User;

@Service
public class RestService {

    @Value("${request.url}")
    private String requestUrl;

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        // set connection and read timeouts
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
    }

    public User getNewUserFromApi() {
        var userResponse = this.restTemplate.getForObject(requestUrl, ApiResponse.class);
        var userData = userResponse.getResults()[0];
        userData.setTimeAdded(new Date().getTime());
        return userData;
    }

}

