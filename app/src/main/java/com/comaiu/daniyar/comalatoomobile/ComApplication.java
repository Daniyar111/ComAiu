package com.comaiu.daniyar.comalatoomobile;

import android.app.Application;
import android.content.Context;

import com.comaiu.daniyar.comalatoomobile.data.db.SQLiteHelper;
import com.comaiu.daniyar.comalatoomobile.utils.PreferenceUtils;

public class ComApplication extends Application {

    private SQLiteHelper mSQLiteHelper;
    private PreferenceUtils mPreferenceUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        mSQLiteHelper = new SQLiteHelper(getApplicationContext());
        mPreferenceUtils = new PreferenceUtils(this);
    }

    public static ComApplication get(Context context){
        return (ComApplication) context.getApplicationContext();
    }

    public SQLiteHelper getSQLiteHelper() {
        return mSQLiteHelper;
    }
}
