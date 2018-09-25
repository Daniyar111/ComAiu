package com.example.daniyar.comalatoomobile;

import android.app.Application;
import android.content.Context;

import com.example.daniyar.comalatoomobile.data.db.SQLiteHelper;
import com.example.daniyar.comalatoomobile.data.network.NetworkBuilder;
import com.example.daniyar.comalatoomobile.data.network.RetrofitService;

public class ComApplication extends Application {

    private RetrofitService mService;
    private SQLiteHelper mSQLiteHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mService = NetworkBuilder.initService();
        mSQLiteHelper = new SQLiteHelper(getApplicationContext());
    }

    public static ComApplication get(Context context){
        return (ComApplication) context.getApplicationContext();
    }

    public RetrofitService getService() {
        return mService;
    }

    public SQLiteHelper getSQLiteHelper() {
        return mSQLiteHelper;
    }
}
