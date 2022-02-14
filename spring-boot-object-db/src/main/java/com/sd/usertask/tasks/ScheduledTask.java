package com.sd.usertask.tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sd.usertask.entities.UserEntity;
import com.sd.usertask.operations.CustomComparator;
import com.sd.usertask.services.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Value("${request.usersize}")
    private int userSize;

    @Autowired
    private RestService restService;
    public static List<UserEntity> usersArray = new ArrayList<UserEntity>();

    @Scheduled(fixedRateString = "${request.period}")
	public void getConstantlyNewUser() {
		var data = restService.getNewUserFromApi();
        UserEntity n = new UserEntity();
        n.setGender(data.getGender());
        n.setName(data.getName().getFirst() + ' ' + data.getName().getLast());
        n.setEmail(data.getEmail());
        n.setCountry(data.getLocation().getCountry());
        n.setPicture(data.getPicture().getThumbnail());
        n.setTimeAdded(data.getTimeAdded());
        usersArray.add(n);
        Collections.sort(usersArray, new CustomComparator());
	}

    public List<UserEntity> returnAllStoredUsers() {
        return limitListLength(usersArray, userSize);
    }

    public List<UserEntity> returnAllUsersFromCountry(String country) {
        var countryUsers = usersArray.stream().filter(user -> user.getCountry().equals(country)).collect(Collectors.toList());
        return limitListLength(countryUsers, userSize);
    }

    public Set<String> returnAllUniqueCountries() {
        var allCountries = usersArray.stream().map(user -> user.getCountry()).collect(Collectors.toList());
        Set<String> countriesSet = new HashSet<String>(allCountries);
        return countriesSet;
    }


    private static List<UserEntity> limitListLength(List<UserEntity> array, int limit) {
        int arraySize = array.size();
        var usedArraySize = limit;
        if (arraySize < limit) {
            usedArraySize = arraySize;
        }
        UserEntity[] LimitedUserSize = new UserEntity[usedArraySize];
        for(int i = 0; i < usedArraySize; i++) {
            LimitedUserSize[i] = array.get(i);
        }
        return Arrays.asList(LimitedUserSize);
    }

}
