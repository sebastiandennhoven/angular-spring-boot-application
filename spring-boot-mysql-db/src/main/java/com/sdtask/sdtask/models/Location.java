package com.sdtask.sdtask.models;
import java.io.Serializable;

public class Location implements Serializable {
    private String country;

    public Location() {}

    public Location(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" +
                "\"country\":" + '\"' + country + '\"' +
                '}';
    }
}
