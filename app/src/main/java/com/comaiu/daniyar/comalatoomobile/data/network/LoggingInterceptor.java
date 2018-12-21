package com.comaiu.daniyar.comalatoomobile.data.network;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class LoggingInterceptor implements Interceptor {

    private final Interceptor mInterceptor;

    private LoggingInterceptor() {
        mInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @NonNull
    public static Interceptor create(){
        return new LoggingInterceptor();
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        return mInterceptor.intercept(chain);
    }
}
