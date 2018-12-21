package com.comaiu.daniyar.comalatoomobile.data.network;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseInterceptor implements Interceptor {

    public BaseInterceptor(){
    }

    public static Interceptor create(){
        return new BaseInterceptor();
    }

    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Accept", "application/json;versions=1")
                .build();
        return chain.proceed(request);
    }
}
