package com.example.daniyar.comalatoomobile.ui.timetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.example.daniyar.comalatoomobile.data.manager.RetrofitServiceManager;
import com.example.daniyar.comalatoomobile.data.manager.SystemServiceManager;
import com.example.daniyar.comalatoomobile.ui.timetable.day.TimetableDayFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimetablePresenter implements TimetableContract.Presenter {

    private TimetableContract.View mView;
    private RetrofitServiceManager mServiceManager;
    private TimetableModel mTimetableModel;
    private List<Fragment> mFragments;
    private SharedPreferences mSharedPreferences;
    private SystemServiceManager mSystemServiceManager;

    TimetablePresenter(RetrofitServiceManager serviceManager, SharedPreferences sharedPreferences, SystemServiceManager systemServiceManager){
        mServiceManager = serviceManager;
        mFragments = new ArrayList<>();
        mSharedPreferences = sharedPreferences;
        mSystemServiceManager = systemServiceManager;
    }

    @Override
    public void getTimetableData() {
        ConnectivityManager manager = (ConnectivityManager) mSystemServiceManager.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(manager != null){
            if(manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnected()){
                getSavedTimetable();
            }
            else{
                getSavedTimetable();
            }
        }
    }

    @Override
    public int getCurrentDay() {

        Calendar currentTime = Calendar.getInstance();
        currentTime.setTime(Calendar.getInstance().getTime());
        int dayOfWeek = currentTime.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 1){
            return 0;
        }
        else{
            return dayOfWeek - 2;
        }
    }

    @Override
    public void getTimetable() {
        if(isViewAttached()){
            mView.showLoadingIndicator();
            mServiceManager.getTimetable().enqueue(new Callback<TimetableModel>() {
                @Override
                public void onResponse(@NonNull Call<TimetableModel> call, @NonNull Response<TimetableModel> response) {
                    if(response.body() != null && response.isSuccessful()){
                        if(isViewAttached()){
                            mView.hideLoadingIndicator();
                            mTimetableModel = response.body();
                            SharedPreferences.Editor editor = mSharedPreferences.edit();
                            Gson gson = new Gson();
                            String jsonTimetable = gson.toJson(mTimetableModel);
                            editor.putString("timetable", jsonTimetable);
                            editor.apply();
                            for (int i = 0; i < mTimetableModel.getWeeks().size(); i++) {
                                ArrayList<String> times = new ArrayList<>(mTimetableModel.getTimes());
                                mFragments.add(TimetableDayFragment.newInstance(mTimetableModel.getWeekDays().get(i),  times, mTimetableModel.getWeeks().get(i)));
                            }
                            mView.onSuccess(mFragments);
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<TimetableModel> call, @NonNull Throwable t) {
                    if(isViewAttached()){
                        mView.hideLoadingIndicator();
                        mView.onFailure(t.getMessage());
                    }
                }
            });
        }
    }

    @Override
    public void getSavedTimetable() {
        Gson gson = new Gson();
        String json = mSharedPreferences.getString("timetable", "");
        TimetableModel timetableModel = gson.fromJson(json, TimetableModel.class);
        if(timetableModel != null) {
            for (int i = 0; i < timetableModel.getWeeks().size(); i++) {
                ArrayList<String> times = new ArrayList<>(timetableModel.getTimes());
                mFragments.add(TimetableDayFragment.newInstance(timetableModel.getWeekDays().get(i), times, timetableModel.getWeeks().get(i)));
            }
            if(isViewAttached()){
                mView.onSuccess(mFragments);
            }
        }
        else {
            getTimetable();
        }
    }

    @Override
    public void bind(TimetableContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    private boolean isViewAttached(){
        return mView != null;
    }
}
