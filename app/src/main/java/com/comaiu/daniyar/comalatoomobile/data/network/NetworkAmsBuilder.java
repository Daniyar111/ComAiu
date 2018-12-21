package com.comaiu.daniyar.comalatoomobile.data.network;

import android.support.annotation.NonNull;

import com.comaiu.daniyar.comalatoomobile.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkAmsBuilder {

    private static volatile RetrofitService sService;

    private static OkHttpClient sClient;

    public NetworkAmsBuilder(){}

    public static RetrofitService initService(){

        RetrofitService service = sService;
        if(service == null){
            synchronized (NetworkBuilder.class){
                service = sService;
                if(service == null){
                    service = sService = buildRetrofitAms().create(RetrofitService.class);
                }
            }
        }
        return service;
    }

    @NonNull
    private static Retrofit buildRetrofitAms(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.AMS_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static void recreateAmsService(){
        sClient = null;
        sClient = getClient();
        sService = buildRetrofitAms().create(RetrofitService.class);
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
                .addInterceptor(ApiKeyInterceptor.create())
                .build();
    }
}
