package com.example.daniyar.comalatoomobile;

import android.app.Application;
import android.content.Context;

import com.example.daniyar.comalatoomobile.data.network.NetworkBuilder;
import com.example.daniyar.comalatoomobile.data.network.RetrofitService;

public class ComApplication extends Application {

    private RetrofitService mService;

    @Override
    public void onCreate() {
        super.onCreate();
        mService = NetworkBuilder.initService();
    }

    public static ComApplication get(Context context){
        return (ComApplication) context.getApplicationContext();
    }

    public RetrofitService getService() {
        return mService;
    }
}
