package com.comaiu.daniyar.comalatoomobile.data.manager;

import android.content.Context;

import com.comaiu.daniyar.comalatoomobile.ComApplication;
import com.comaiu.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.comaiu.daniyar.comalatoomobile.data.network.RetrofitService;

import retrofit2.Call;

public final class RetrofitServiceManager {

    private Context mContext;
    private RetrofitService mService;

    public RetrofitServiceManager(Context context){
        mContext = context;
        mService = ComApplication.get(mContext).getService();
    }

    public Call<TimetableModel> getTimetable(){
        return mService.getTimetable();
    }
}
