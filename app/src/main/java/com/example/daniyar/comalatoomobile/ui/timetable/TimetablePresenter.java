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
import java.util.Calendar;
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
        Log.d("CURRENTDAN", "getCurrentDay: " + dayOfWeek);
        if(dayOfWeek == 1){
            return 0;
        }
        else{
            return dayOfWeek - 2;
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

                    mRealmTimetable = realm.createObject(TimetableModel.class);
                    for (int i = 0; i < mTimetableModel.getTimes().size(); i++) {
                        times.add(mTimetableModel.getTimes().get(i));
                        mRealmTimetable.setTimes(times);
                    }

                    for (int i = 0; i < mTimetableModel.getWeekDays().size(); i++) {
                        weekDays.add(mTimetableModel.getWeekDays().get(i));
                        mRealmTimetable.setWeekDays(weekDays);
                    }

                    for (int i = 0; i < mTimetableModel.getWeeks().size(); i++) {
                        Week week = realm.createObject(Week.class);
                        RealmList<OneA> oneAS = new RealmList<>();
                        RealmList<OneB> oneBS = new RealmList<>();
                        RealmList<Two> twos = new RealmList<>();
                        RealmList<TwoA> twoAS = new RealmList<>();
                        RealmList<TwoB> twoBS = new RealmList<>();
                        RealmList<Three> threes = new RealmList<>();
                        RealmList<Four> fours = new RealmList<>();

                        if(mTimetableModel.getWeeks().get(i).getOneAS() != null){
                            for (int k = 0; k < mTimetableModel.getWeeks().get(i).getOneAS().size(); k++) {
                                OneA oneA = realm.createObject(OneA.class);
                                oneA.setName(mTimetableModel.getWeeks().get(i).getOneAS().get(k).getName());
                                oneA.setOther(mTimetableModel.getWeeks().get(i).getOneAS().get(k).getOther());
                                oneAS.add(oneA);
                            }
                        }
                        if(mTimetableModel.getWeeks().get(i).getOneAS() == null){
                            oneAS = null;
                        }
                        if(mTimetableModel.getWeeks().get(i).getOneBS() != null){
                            for (int k = 0; k < mTimetableModel.getWeeks().get(i).getOneBS().size(); k++) {
                                OneB oneB = realm.createObject(OneB.class);
                                oneB.setName(mTimetableModel.getWeeks().get(i).getOneBS().get(k).getName());
                                oneB.setOther(mTimetableModel.getWeeks().get(i).getOneBS().get(k).getOther());
                                oneBS.add(oneB);
                            }
                        }
                        if(mTimetableModel.getWeeks().get(i).getOneBS() == null){
                            oneBS = null;
                        }
                        if(mTimetableModel.getWeeks().get(i).getTwos() != null){
                            for (int k = 0; k < mTimetableModel.getWeeks().get(i).getTwos().size(); k++) {
                                Two two = realm.createObject(Two.class);
                                two.setName(mTimetableModel.getWeeks().get(i).getTwos().get(k).getName());
                                two.setOther(mTimetableModel.getWeeks().get(i).getTwos().get(k).getOther());
                                twos.add(two);
                            }
                        }
                        if(mTimetableModel.getWeeks().get(i).getTwos() == null){
                            twos = null;
                        }
                        if(mTimetableModel.getWeeks().get(i).getTwoAS() != null){
                            for (int k = 0; k < mTimetableModel.getWeeks().get(i).getTwoAS().size(); k++) {
                                TwoA twoA = realm.createObject(TwoA.class);
                                twoA.setName(mTimetableModel.getWeeks().get(i).getTwoAS().get(k).getName());
                                twoA.setOther(mTimetableModel.getWeeks().get(i).getTwoAS().get(k).getOther());
                                twoAS.add(twoA);
                            }
                        }
                        if(mTimetableModel.getWeeks().get(i).getTwoAS() == null){
                            twoAS = null;
                        }
                        if(mTimetableModel.getWeeks().get(i).getTwoBS() != null){
                            for (int k = 0; k < mTimetableModel.getWeeks().get(i).getTwoBS().size(); k++) {
                                TwoB twoB = realm.createObject(TwoB.class);
                                twoB.setName(mTimetableModel.getWeeks().get(i).getTwoBS().get(k).getName());
                                twoB.setOther(mTimetableModel.getWeeks().get(i).getTwoBS().get(k).getOther());
                                twoBS.add(twoB);
                            }
                        }
                        if(mTimetableModel.getWeeks().get(i).getTwoBS() == null){
                            twoBS = null;
                        }
                        if(mTimetableModel.getWeeks().get(i).getThrees() != null){
                            for (int k = 0; k < mTimetableModel.getWeeks().get(i).getThrees().size(); k++) {
                                Three three = realm.createObject(Three.class);
                                three.setName(mTimetableModel.getWeeks().get(i).getThrees().get(k).getName());
                                three.setOther(mTimetableModel.getWeeks().get(i).getThrees().get(k).getOther());
                                threes.add(three);
                            }
                        }
                        if(mTimetableModel.getWeeks().get(i).getThrees() == null){
                            threes = null;
                        }
                        if(mTimetableModel.getWeeks().get(i).getFours() != null){
                            for (int k = 0; k < mTimetableModel.getWeeks().get(i).getFours().size(); k++) {
                                Four four = realm.createObject(Four.class);
                                four.setName(mTimetableModel.getWeeks().get(i).getFours().get(k).getName());
                                four.setOther(mTimetableModel.getWeeks().get(i).getFours().get(k).getOther());
                                fours.add(four);
                            }
                        }
                        if(mTimetableModel.getWeeks().get(i).getFours() == null){
                            fours = null;
                        }
                        week.setOneAS(oneAS);
                        week.setOneBS(oneBS);
                        week.setTwos(twos);
                        week.setTwoAS(twoAS);
                        week.setTwoBS(twoBS);
                        week.setThrees(threes);
                        week.setFours(fours);
                        weeks.add(week);
                    }
                    mRealmTimetable.setWeeks(weeks);
                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    Log.d("REALMSUCCESS", "success");

                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(@NonNull Throwable error) {
                    Log.d("REALMSUCCESS", error.getMessage());
                    for (int i = 0; i < mTimetableModel.getWeeks().size(); i++) {
                        Log.d("REALMSUCCESS", mTimetableModel.getWeeks().get(i).toString());

                    }
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
                            SharedPreferences.Editor editor = mSharedPreferences.edit();
                            Gson gson = new Gson();
                            String jsonTimetable = gson.toJson(mTimetableModel);
                            editor.putString("timetable", jsonTimetable);
                            editor.apply();
                            for (int i = 0; i < mTimetableModel.getWeeks().size(); i++) {
                                ArrayList<String> times = new ArrayList<>(mTimetableModel.getTimes());
                                mFragments.add(TimetableDayFragment.newInstance(mTimetableModel.getWeekDays().get(i),  times, mTimetableModel.getWeeks().get(i)));
                            }
//                            writeToRealm();
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
//        TimetableModel timetableModel = mRealm.where(TimetableModel.class).findFirst();
//        List<Fragment> fragments = new ArrayList<>();
//        Log.d("DANISAVE", "offline");
//
//        if(timetableModel != null){
//            for (int i = 0; i < timetableModel.getWeeks().size(); i++) {
//                ArrayList<String> times = new ArrayList<>(timetableModel.getTimes());
//                Log.d("SAVEDAN", "weekdays: " + timetableModel.getWeekDays().get(i));
//                Log.d("SAVEDAN", "times: " + times);
//                Log.d("SAVEDAN", "weeks: " + timetableModel.getWeeks().get(i));
//                fragments.add(TimetableDayFragment.newInstance(timetableModel.getWeekDays().get(i), times, timetableModel.getWeeks().get(i)));
//            }
//            if(isViewAttached()){
//                mView.onSuccess(fragments);
//            }
//        }
        Gson gson = new Gson();
        String json = mSharedPreferences.getString("timetable", "");
        TimetableModel timetableModel = gson.fromJson(json, TimetableModel.class);
        if(timetableModel != null) {
            Log.d("DANISAVE", "offline");
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
        Log.d("REALMDAN", "off " + String.valueOf(timetableModel));
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
