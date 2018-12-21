package com.comaiu.daniyar.comalatoomobile.data.network;

import android.support.annotation.NonNull;

import com.comaiu.daniyar.comalatoomobile.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkBuilder {

    private static volatile RetrofitService sService;

    private static OkHttpClient sClient;

    public NetworkBuilder(){}

    public static RetrofitService initService(){

        RetrofitService service = sService;
        if(service == null){
            synchronized (NetworkBuilder.class){
                service = sService;
                if(service == null){
                    service = sService = buildRetrofitTimetable().create(RetrofitService.class);
                }
            }
        }
        return service;
    }

    @NonNull
    private static Retrofit buildRetrofitTimetable(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.TIMETABLE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static void recreateTimetableService(){
        sClient = null;
        sClient = getClient();
        sService = buildRetrofitTimetable().create(RetrofitService.class);
    }

    private static OkHttpClient getClient(){

        OkHttpClient client = sClient;
        if(client == null){
            synchronized (NetworkBuilder.class){
                client = sClient;
                if(client == null){
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.create())
                .addInterceptor(BaseInterceptor.create())
                .build();
    }
}
