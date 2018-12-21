package com.comaiu.daniyar.comalatoomobile.data.repository;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public class RepositoryProvider {

    private static UserRepository sUserRepository;

    private RepositoryProvider(){

    }

    @NonNull
    public static UserRepository provideUserRepository(){
        if(sUserRepository == null){
            sUserRepository = new DefaultUserRepository();
        }
        return sUserRepository;
    }

    public static void setUserRepository(@NonNull UserRepository userRepository) {
        sUserRepository = userRepository;
    }

    @MainThread
    public static void init(){
        sUserRepository = new DefaultUserRepository();
    }
}
