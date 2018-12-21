package com.comaiu.daniyar.comalatoomobile.ui.ams;

import android.text.TextUtils;
import android.util.Log;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.config.AppConstants;
import com.comaiu.daniyar.comalatoomobile.data.entity.ams.TermModel;
import com.comaiu.daniyar.comalatoomobile.data.entity.ams.YearAmsModel;
import com.comaiu.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.comaiu.daniyar.comalatoomobile.data.repository.RepositoryProvider;
import com.comaiu.daniyar.comalatoomobile.utils.PreferenceUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import io.reactivex.disposables.Disposable;

public class AmsPresenter implements AmsContract.Presenter {

    private AmsContract.View mView;
    private ResourceManager mResourceManager;
    private Disposable mDisposableLogin;


    public AmsPresenter(ResourceManager resourceManager){
        mResourceManager = resourceManager;

    }

    @Override
    public void getLoginPass() {
        String email = PreferenceUtils.getEmail();
        String password = PreferenceUtils.getPassword();
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            if(isViewAttached()) mView.fillTheFields(email, password);
        }
    }

    @Override
    public void loginTo(String id, String pass) {
        if(TextUtils.isEmpty(id) && TextUtils.isEmpty(pass)){
            if(isViewAttached()) mView.toastError(mResourceManager.getResources().getString(R.string.write_login), "both");
        }
        else if(TextUtils.isEmpty(id)){
            if (isViewAttached()) mView.toastError(mResourceManager.getResources().getString(R.string.email_error), "email");
        }
        else if(TextUtils.isEmpty(pass)){
            if(isViewAttached()) mView.toastError(mResourceManager.getResources().getString(R.string.password_error), "password");
        }
        else{
            mDisposableLogin = RepositoryProvider.provideUserRepository()
                    .auth(id, pass)
                    .doOnSubscribe(disposable ->{
                        if(isViewAttached())mView.showLoadingIndicator();
                    })
                    .doOnTerminate(mView::hideLoadingIndicator)
                    .subscribe(isLogged -> {
                        if(isLogged){
                            if(isViewAttached()) mView.goToMain();
                        }
                        else{
                            if(isViewAttached()) mView.toastText(mResourceManager.getResources().getString(R.string.credentials_error));
                        }
                    }, throwable -> {
                        throwable.printStackTrace();
                        if(isViewAttached()){
                            mView.toastText(mResourceManager.getResources().getString(R.string.connection_error));
                        }
                    });
        }
    }

    @Override
    public void bind(AmsContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    private boolean isViewAttached(){
        return mView != null;
    }

    @Override
    public void onDestroy() {
        if(mDisposableLogin != null){
            mDisposableLogin.dispose();
        }
    }
}
