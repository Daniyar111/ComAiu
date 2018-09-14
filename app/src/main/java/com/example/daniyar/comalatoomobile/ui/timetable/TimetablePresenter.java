package com.example.daniyar.comalatoomobile.ui.timetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.daniyar.comalatoomobile.data.db.SQLiteHelper;
import com.example.daniyar.comalatoomobile.data.entity.ViewPagerItem;
import com.example.daniyar.comalatoomobile.data.entity.timetable.Four;
import com.example.daniyar.comalatoomobile.data.entity.timetable.OneA;
import com.example.daniyar.comalatoomobile.data.entity.timetable.OneB;
import com.example.daniyar.comalatoomobile.data.entity.timetable.Three;
import com.example.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.example.daniyar.comalatoomobile.data.entity.timetable.Two;
import com.example.daniyar.comalatoomobile.data.entity.timetable.TwoA;
import com.example.daniyar.comalatoomobile.data.entity.timetable.TwoB;
import com.example.daniyar.comalatoomobile.data.entity.timetable.Week;
import com.example.daniyar.comalatoomobile.data.manager.RetrofitServiceManager;
import com.example.daniyar.comalatoomobile.data.manager.SystemServiceManager;
import com.example.daniyar.comalatoomobile.ui.timetable.day.TimetableDayFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
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
    private Realm mRealm;
    private TimetableModel mRealmTimetable;

    TimetablePresenter(RetrofitServiceManager serviceManager, SQLiteHelper sqLiteHelper, SharedPreferences sharedPreferences, SystemServiceManager systemServiceManager, Realm realm){
        mServiceManager = serviceManager;
        mFragments = new ArrayList<>();
        mSharedPreferences = sharedPreferences;
        mSystemServiceManager = systemServiceManager;
        mRealm = realm;
    }

    @Override
    public void getTimetableData() {
        ConnectivityManager manager = (ConnectivityManager) mSystemServiceManager.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(manager != null){
            if(manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnected()){
//                getSavedTimetable();
                getTimetable();
            }
            else{
                getSavedTimetable();
            }
        }
    }

    @Override
    public void writeToRealm() {
        if(mRealm.where(TimetableModel.class).findAll().size() == 0){
            mRealm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(@NonNull Realm realm) {
                    RealmList<String> times = new RealmList<>();
                    RealmList<String> weekDays = new RealmList<>();
                    RealmList<Week> weeks = new RealmList<>();
                    RealmList<OneA> oneAS = new RealmList<>();
                    RealmList<OneB> oneBS = new RealmList<>();
                    RealmList<Two> twos = new RealmList<>();
                    RealmList<TwoA> twoAS = new RealmList<>();
                    RealmList<TwoB> twoBS = new RealmList<>();
                    RealmList<Three> threes = new RealmList<>();
                    RealmList<Four> fours = new RealmList<>();
                    OneA oneA;
                    TimetableModel timetableModel;
                    timetableModel = realm.createObject(TimetableModel.class);
                    for (int i = 0; i < mTimetableModel.getTimes().size(); i++) {
                        times.add(mTimetableModel.getTimes().get(i));
                        timetableModel.setTimes(times);
                    }
                    for (int i = 0; i < mTimetableModel.getWeekDays().size() - 1; i++) {
                        weekDays.add(mTimetableModel.getWeekDays().get(i));
                        timetableModel.setWeekDays(weekDays);
                    }
//                    for (int i = 0; i < mTimetableModel.getWeeks().size(); i++) {
//                        for (int j = 0; j < mTimetableModel.getWeeks().get(i).getOneAS().size(); j++) {
//                            oneA = realm.createObject(OneA.class);
//                            oneA.setName();
//                        }
//                        oneAS = mTimetableModel.getWeeks().get(i).getOneAS();
//                        oneAS.get(i).setName(mTimetableModel.getWeeks().get(i).getOneAS().get(i).getName());
//                        oneBS = mTimetableModel.getWeeks().get(i).getOneBS();
//                        twos = mTimetableModel.getWeeks().get(i).getTwos();
//                        twoAS = mTimetableModel.getWeeks().get(i).getTwoAS();
//                        twoBS = mTimetableModel.getWeeks().get(i).getTwoBS();
//                        threes = mTimetableModel.getWeeks().get(i).getThrees();
//                        fours = mTimetableModel.getWeeks().get(i).getFours();
//
//                        Log.d("REALM_DAN", "execute: " + oneAS);
//
//                    }

                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {

                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(@NonNull Throwable error) {
                    Log.d("REALM_DAN", error.getMessage());
                }
            });
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
//                            SharedPreferences.Editor editor = mSharedPreferences.edit();
//                            Gson gson = new Gson();
//                            String json = gson.toJson(mTimetableModel);
//                            editor.putString("timetable", json);
//                            editor.commit();
//                            for (int i = 0; i < mTimetableModel.getWeeks().size(); i++) {
//                                mFragments.add(TimetableDayFragment.newInstance(mTimetableModel.getWeekDays().get(i),  mTimetableModel.getTimes(), mTimetableModel.getWeeks().get(i)));
//                            }
//                            Log.d("DANISAVE", "online");

                            writeToRealm();
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
//        Gson gson = new Gson();
//        String json = mSharedPreferences.getString("timetable", "");
//        TimetableModel timetableModel = gson.fromJson(json, TimetableModel.class);
//        if(timetableModel != null){
//            Log.d("DANISAVE", "offline");
//            for (int i = 0; i < timetableModel.getWeeks().size(); i++) {
//                mFragments.add(TimetableDayFragment.newInstance(timetableModel.getWeekDays().get(i),  timetableModel.getTimes(), timetableModel.getWeeks().get(i)));
//            }
////            Log.d("SAVEDAN", "getSavedTimetable: " + timetableModel);
//            if(isViewAttached()){
//                mView.onSuccess(mFragments);
//            }
//        }

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
