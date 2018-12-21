package com.comaiu.daniyar.comalatoomobile.ui.ams.ams_terms;

import android.util.Log;

import com.comaiu.daniyar.comalatoomobile.config.AppConstants;
import com.comaiu.daniyar.comalatoomobile.data.entity.ams.TermModel;
import com.comaiu.daniyar.comalatoomobile.data.entity.ams.YearAmsModel;
import com.comaiu.daniyar.comalatoomobile.data.repository.RepositoryProvider;
import com.comaiu.daniyar.comalatoomobile.utils.PreferenceUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import io.reactivex.disposables.Disposable;

public class AmsTermsPresenter implements AmsTermsContract.Presenter {

    private AmsTermsContract.View mView;
    private Disposable mDisposableScore;
    private ArrayList<String> mYears;
    private ArrayList<TermModel> mTermModels;

    AmsTermsPresenter(){

    }

    @Override
    public void getScore(String year, String term) {
        mDisposableScore = RepositoryProvider.provideUserRepository()
                .getScore(year, term)
                .doOnSubscribe(disposable -> {
                    if(isViewAttached()) mView.showLoadingIndicator();
                })
                .doOnTerminate(mView::hideLoadingIndicator)
                .subscribe(amsModel -> {
                    if(amsModel.entrySet().size() != 0){
                        Log.d("ADSSDA", amsModel.toString());
                        if(isViewAttached()) mView.onSuccess();
                        initTermsList(amsModel);
                    }
                    else{
                        Log.d("DANIAMS", "fail");
                        if(isViewAttached()) mView.onFailure();
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                    Log.d("DANIAMS", "error");
                });
    }

    @Override
    public void initAllStudyYears() {

    }

    @Override
    public ArrayList<String> getStudyYears() {
        return mYears;
    }

    @Override
    public void initStudyYears(){
        mYears = new ArrayList<>();
        int idYear = Integer.parseInt(cutYearFromId());
        int currentYear = Integer.parseInt(getCurrentYear());
        int temp;
        while(idYear <= currentYear){
            temp = idYear;
            idYear++;
            mYears.add(String.valueOf(temp) + "-" + idYear + " " + AppConstants.FALL);
            mYears.add(String.valueOf(temp) + "-" + idYear + " " + AppConstants.SPRING);
        }
//        if(isViewAttached()) mView.goToMain();
//        initAllStudyYears();
    }

    @Override
    public void selectSpinner() {
        int currentMonth = Integer.parseInt(getCurrentMonth());
        if(currentMonth >= 9 && isViewAttached()){
            mView.selectPreLastSpinner();
        }else{
            if (isViewAttached()) mView.selectLastSpinner();
        }
    }

    private void initTermsList(JsonObject amsModel){
        YearAmsModel yearAmsModel = new YearAmsModel();
        mTermModels = new ArrayList<>();
        Set<String> name = amsModel.keySet();
        List<String> list = new ArrayList<>(name);
        yearAmsModel.setYear(list.get(0));
        JsonArray array = amsModel.getAsJsonArray(list.get(0));
        for (int i = 0; i < array.size(); i++) {
            TermModel termModel = new TermModel();
            JsonObject jsonObject = array.get(i).getAsJsonObject();
            termModel.setFinal(jsonObject.get(AppConstants.FINAL).getAsString());
            termModel.setMidterm(jsonObject.get(AppConstants.MIDTERM).getAsString());
            termModel.setSubject(jsonObject.get(AppConstants.SUBJECT).getAsString());
            mTermModels.add(termModel);
        }
        yearAmsModel.setTermModels(mTermModels);
        Log.d("ADSSDA", " some " + yearAmsModel.toString());
        if(isViewAttached()){
            mView.updateAdapter(yearAmsModel);
        }
    }

    private String cutYearFromId(){
        return "20" + PreferenceUtils.getEmail().substring(0, 2);
    }

    private String getCurrentYear(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy", Locale.getDefault());
        return formatDate.format(calendar.getTime());
    }

    private String getCurrentMonth(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatDate = new SimpleDateFormat("MM", Locale.getDefault());
        return formatDate.format(calendar.getTime());
    }

    @Override
    public void bind(AmsTermsContract.View view) {
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
        if(mDisposableScore != null){
            mDisposableScore.dispose();
        }
    }
}
