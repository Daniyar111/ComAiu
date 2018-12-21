package com.comaiu.daniyar.comalatoomobile.data.repository;

import android.support.annotation.NonNull;
import android.util.Log;

import com.comaiu.daniyar.comalatoomobile.data.entity.ams.LoginResponseModel;
import com.comaiu.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.comaiu.daniyar.comalatoomobile.data.network.NetworkAmsBuilder;
import com.comaiu.daniyar.comalatoomobile.data.network.NetworkBuilder;
import com.comaiu.daniyar.comalatoomobile.utils.GenerateUtils;
import com.comaiu.daniyar.comalatoomobile.utils.PreferenceUtils;
import com.comaiu.daniyar.comalatoomobile.utils.RxUtils;
import com.google.gson.JsonObject;

import io.reactivex.Observable;

public class DefaultUserRepository implements UserRepository {

    @Override
    public Observable<TimetableModel> getTimetable() {
        return NetworkBuilder.initService()
                .getTimetable()
                .compose(RxUtils.async())
                .flatMap(response -> {
                    if(response.isSuccessful() && response.body() != null){
                        return Observable.just(response.body());
                    }
                    else{
                        return Observable.just(null);
                    }
                });
    }

    @NonNull
    @Override
    public Observable<Boolean> auth(@NonNull String id, @NonNull String pass) {
        return NetworkAmsBuilder.initService()
                .login(id, GenerateUtils.generatePass(pass))
                .compose(RxUtils.async())
                .flatMap(response -> {
                    if(response.isSuccessful()){
                        LoginResponseModel responseModel = response.body();
                        PreferenceUtils.setToken(responseModel.getToken());
                        PreferenceUtils.setEmail(id);
                        PreferenceUtils.setPassword(pass);
                        NetworkAmsBuilder.recreateAmsService();
                        return Observable.just(true);
                    }
                    else{
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<JsonObject> getScore(String year, String term) {
        return NetworkAmsBuilder.initService()
                .getScore(year, term)
                .compose(RxUtils.async())
                .flatMap(response ->{
                    if(response.isSuccessful() && response.code() == 200 && response.body() != null){
                        Log.d("DANIAMS", response.body().toString());
                        return Observable.just(response.body());
                    }
                    else{
                        return Observable.just(null);
                    }
                });
    }


}
