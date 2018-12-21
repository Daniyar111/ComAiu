package com.comaiu.daniyar.comalatoomobile.data.repository;

import android.support.annotation.NonNull;

import com.comaiu.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.google.gson.JsonObject;

import io.reactivex.Observable;


public interface UserRepository {

    Observable<TimetableModel> getTimetable();

    @NonNull
    Observable<Boolean> auth(@NonNull String id, @NonNull String pass);

    Observable<JsonObject> getScore(String year, String term);
}
