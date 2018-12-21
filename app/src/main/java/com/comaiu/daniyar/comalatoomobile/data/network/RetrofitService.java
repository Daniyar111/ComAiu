package com.comaiu.daniyar.comalatoomobile.data.network;

import com.comaiu.daniyar.comalatoomobile.config.AppConstants;
import com.comaiu.daniyar.comalatoomobile.data.entity.ams.LoginResponseModel;
import com.comaiu.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET(AppConstants.TIMETABLE_ENDPOINT)
    Observable<Response<TimetableModel>> getTimetable();

    @POST(AppConstants.AMS_ENDPOINT + "{id}" + "/{pass}")
    Observable<Response<LoginResponseModel>> login(@Path("id") String id, @Path("pass") String pass);

    @GET(AppConstants.AMS_MARK + "{year}" + "/{term}")
    Observable<Response<JsonObject>> getScore(@Path("year") String year, @Path("term") String term);
}
