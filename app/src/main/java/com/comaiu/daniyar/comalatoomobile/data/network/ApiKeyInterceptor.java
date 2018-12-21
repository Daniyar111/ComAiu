package com.comaiu.daniyar.comalatoomobile.data.network;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.comaiu.daniyar.comalatoomobile.utils.PreferenceUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyInterceptor implements Interceptor{

    private String token;

    public ApiKeyInterceptor(){
        token = PreferenceUtils.getToken();
    }

    public static Interceptor create(){
        return new ApiKeyInterceptor();
    }

    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        if(TextUtils.isEmpty(token)){
            return chain.proceed(chain.request());
        }
        Request request = chain.request().newBuilder()
                .addHeader("Bearer", token)
                .build();
        return chain.proceed(request);
    }
}
