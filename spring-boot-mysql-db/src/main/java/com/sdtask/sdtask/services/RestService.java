package com.sdtask.sdtask.services;
import com.sdtask.sdtask.entities.UserEntity;
import com.sdtask.sdtask.models.ApiResponse;
import com.sdtask.sdtask.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate; 
import java.time.Duration;
import java.util.*;

@Service
public class RestService {

    @Value("${request.url}")
    private String requestUrl;

    private final RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

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

    public void addNewUserToDatabase(User data) {
        UserEntity n = new UserEntity();
        n.setGender(data.getGender());
        n.setName(data.getName().getFirst() + ' ' + data.getName().getLast());
        n.setEmail(data.getEmail());
        n.setCountry(data.getLocation().getCountry());
        n.setPicture(data.getPicture().getThumbnail());
        n.setTimeAdded(data.getTimeAdded());
        userRepository.save(n);
    }

}

