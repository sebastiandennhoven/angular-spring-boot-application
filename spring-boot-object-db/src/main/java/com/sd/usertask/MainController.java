package com.sd.usertask;
import java.util.List;
import java.util.Set;

import com.sd.usertask.models.Location;
import com.sd.usertask.entities.UserEntity;
import com.sd.usertask.models.User;
import com.sd.usertask.services.RestService;
import com.sd.usertask.tasks.ScheduledTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private RestService restService;
    @Autowired
    private ScheduledTask scheduledTask;

	@GetMapping("/get-random-user")
	public User getRandomUser() {
        System.out.println("==== get random user ====");
		return restService.getNewUserFromApi();
	}

    @CrossOrigin(origins = "*")
    @GetMapping("/get-stored-users")
	public List<UserEntity> getStoredUsers() {
        System.out.println("==== get all stored users ====");
		return scheduledTask.returnAllStoredUsers();
	}

    @CrossOrigin(origins = "*")
    @GetMapping("/get-unique-countries")
	public @ResponseBody Set<String> getAllUniqueCountries() {
        System.out.println("==== get unique countries ====");
		return scheduledTask.returnAllUniqueCountries();
	}

    @CrossOrigin(origins = "*")
    @PostMapping("/get-users-by-country")
	public @ResponseBody Iterable<UserEntity> getUsersByCountry(@RequestBody Location country) {
        System.out.println("==== get random users from country: " + country + " ====");
		return scheduledTask.returnAllUsersFromCountry(country.getCountry());
	}
}
