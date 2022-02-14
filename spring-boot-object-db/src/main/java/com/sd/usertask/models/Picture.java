package com.sd.usertask.models;
import java.io.Serializable;

public class Picture implements Serializable {
    
    private String thumbnail;

    public Picture() {}

    public Picture(String thumbnail, String medium, String large) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "thumbnail=" + thumbnail +
                '}';
    }
}
