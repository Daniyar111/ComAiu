package com.comaiu.daniyar.comalatoomobile.data.entity.ams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponseModel implements Serializable {

    @SerializedName("authToken")
    @Expose
    private String token;

    @SerializedName("expires")
    @Expose
    private String date;

    public LoginResponseModel(){

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
