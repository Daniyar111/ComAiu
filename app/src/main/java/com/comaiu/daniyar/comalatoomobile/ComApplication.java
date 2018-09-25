package com.comaiu.daniyar.comalatoomobile;

import android.app.Application;
import android.content.Context;

import com.comaiu.daniyar.comalatoomobile.data.db.SQLiteHelper;
import com.comaiu.daniyar.comalatoomobile.data.network.NetworkBuilder;
import com.comaiu.daniyar.comalatoomobile.data.network.RetrofitService;

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
