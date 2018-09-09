package com.example.daniyar.comalatoomobile.data.network;

import com.example.daniyar.comalatoomobile.config.AppConstants;
import com.example.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET(AppConstants.COMMON_ENDPOINT)
    Call<TimetableModel> getTimetable();
}
