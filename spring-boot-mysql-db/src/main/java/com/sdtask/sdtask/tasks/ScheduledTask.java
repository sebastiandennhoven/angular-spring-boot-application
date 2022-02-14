package com.sdtask.sdtask.tasks;
import java.util.*;
import com.sdtask.sdtask.services.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    private RestService restService;

    @Scheduled(fixedRateString = "${request.period}")
	public void reportCurrentTime() {
        // Get new user
		var user = restService.getNewUserFromApi();
        // Set current time in milliseconds to enable sorting for it
        user.setTimeAdded(new Date().getTime());
        // Add new user to Database
        restService.addNewUserToDatabase(user);
	}

}
