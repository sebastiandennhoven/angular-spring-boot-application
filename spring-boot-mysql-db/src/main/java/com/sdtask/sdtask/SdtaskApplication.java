package com.sdtask.sdtask;

import com.sdtask.sdtask.services.RestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SdtaskApplication {

	private RestService restService;

    public SdtaskApplication(RestService restService) {
        this.restService = restService;
    }

	public static void main(String[] args) {
		SpringApplication.run(SdtaskApplication.class, args);
	}

}
