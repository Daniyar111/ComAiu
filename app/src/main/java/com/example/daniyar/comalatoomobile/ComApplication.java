package com.example.daniyar.comalatoomobile;

import android.app.Application;
import android.content.Context;

import com.example.daniyar.comalatoomobile.data.db.SQLiteHelper;
import com.example.daniyar.comalatoomobile.data.network.NetworkBuilder;
import com.example.daniyar.comalatoomobile.data.network.RetrofitService;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ComApplication extends Application {

    private RetrofitService mService;
    private SQLiteHelper mSQLiteHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mService = NetworkBuilder.initService();
        mSQLiteHelper = new SQLiteHelper(getApplicationContext());
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().name("myrealm.realm").build();
        Realm.setDefaultConfiguration(configuration);
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
