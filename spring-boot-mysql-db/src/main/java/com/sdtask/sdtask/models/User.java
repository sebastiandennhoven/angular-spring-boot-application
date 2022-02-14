package com.sdtask.sdtask.models;
import java.io.Serializable;

public class User implements Serializable {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Picture picture;
    private long timeAdded;

    public User() {}

    public User(String gender, Name name, Location location, String email, Picture picture) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
    
    public long getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(long timeAdded) {
        this.timeAdded = timeAdded;
    }


    @Override
    public String toString() {
        return "{" +
                "\"gender\":\"" + gender + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"location\":\"" + location  + '\"' +
                ", \"email\":\"" + email + '\"' +
                ", \"picture\":\"" + picture + '\"' +
                ", \"timeAdded\":\"" + timeAdded + '\"' +
                '}';
    }
    
}
