package com.comaiu.daniyar.comalatoomobile.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.comaiu.daniyar.comalatoomobile.config.AppConstants;

public final class PreferenceUtils {

    private static SharedPreferences sSharedPreferences;

    public PreferenceUtils(Context context){
        sSharedPreferences = context.getSharedPreferences("ComAMS", Context.MODE_PRIVATE);
    }

    @NonNull
    public static void setEmail(String email){
        sSharedPreferences.edit().putString(AppConstants.EMAIL, email).apply();
    }

    public static String getEmail(){
        return sSharedPreferences.getString(AppConstants.EMAIL, "");
    }

    @NonNull
    public static void setPassword(String password){
        sSharedPreferences.edit().putString(AppConstants.PASSWORD, password).apply();
    }

    public static String getPassword(){
        return sSharedPreferences.getString(AppConstants.PASSWORD, "");
    }

    @NonNull
    public static void setToken(String token){
        sSharedPreferences.edit().putString(AppConstants.TOKEN, token).apply();
    }

    public static String getToken(){
        return sSharedPreferences.getString(AppConstants.TOKEN, "");
    }
}
