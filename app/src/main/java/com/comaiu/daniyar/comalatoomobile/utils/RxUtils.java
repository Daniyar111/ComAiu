package com.comaiu.daniyar.comalatoomobile.utils;

import android.support.annotation.NonNull;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxUtils {

    @NonNull
    public static <T>ObservableTransformer<T, T> async(){
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
