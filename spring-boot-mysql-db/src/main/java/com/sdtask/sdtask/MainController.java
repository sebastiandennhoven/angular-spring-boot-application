package com.sdtask.sdtask;

import java.util.List;

import com.sdtask.sdtask.entities.UserEntity;
import com.sdtask.sdtask.models.Location;
import com.sdtask.sdtask.models.User;
import com.sdtask.sdtask.services.RestService;
import com.sdtask.sdtask.services.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class MainController {

    @Value("${request.usersize}")
    private int userSize;
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestService restService;


    /**
     * @return Get all stored user, amount of response users is limited by Application settings
     */
    @CrossOrigin(origins = "*")
    @GetMapping(path="/get-stored-users")
    public @ResponseBody Iterable<UserEntity> getAllUsers() {
        return userRepository.findTopN(userSize);
    }

    /**
     * @return All unique countries that are currently in Database
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/get-unique-countries")
	public @ResponseBody List<String> getAllUniqueCountries() {
        System.out.println("==== get unique countries ====");
		return userRepository.findAllUniqueCountries();
	}

    /**
     * @param country
     * @return All users that match search country
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/get-users-by-country")
	public @ResponseBody Iterable<UserEntity> getUsersByCountry(@RequestBody Location country) {
        System.out.println("==== get random users from country: " + country + " ====");
		return userRepository.findTopNInCountry(userSize, country.getCountry());
	}

    
}
