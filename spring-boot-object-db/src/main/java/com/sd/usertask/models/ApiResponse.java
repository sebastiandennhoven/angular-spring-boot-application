package com.sd.usertask.models;
import java.io.Serializable;

public class ApiResponse implements Serializable {

    private User[] results;

    public ApiResponse() {}

    public ApiResponse(User[] results) {
        this.results = results;
    }

    public User[] getResults() {
        return results;
    }

    public void setResults(User[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "results=" + results +
                '}';
    }

}