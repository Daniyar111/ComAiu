package com.example.daniyar.comalatoomobile.ui.timetable;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.example.daniyar.comalatoomobile.data.entity.ViewPagerItem;
import com.example.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.example.daniyar.comalatoomobile.data.manager.RetrofitServiceManager;
import com.example.daniyar.comalatoomobile.ui.timetable.day.TimetableDayFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimetablePresenter implements TimetableContract.Presenter {

    private TimetableContract.View mView;
    private RetrofitServiceManager mServiceManager;
    private TimetableModel mTimetableModel;
    private List<Fragment> mFragments;

    TimetablePresenter(RetrofitServiceManager serviceManager){
        mServiceManager = serviceManager;
        mFragments = new ArrayList<>();
    }

    @Override
    public void getTimetable() {
        if(isViewAttached()){
            mView.showLoadingIndicator();
            mServiceManager.getTimetable().enqueue(new Callback<TimetableModel>() {
                @Override
                public void onResponse(@NonNull Call<TimetableModel> call, @NonNull Response<TimetableModel> response) {
                    if(response.body() != null && response.isSuccessful()){
                        if(isViewAttached()){
                            mView.hideLoadingIndicator();
                            mTimetableModel = response.body();
                            for (int i = 0; i < mTimetableModel.getWeeks().size(); i++) {
                                mFragments.add(TimetableDayFragment.newInstance(mTimetableModel.getWeekDays().get(i), mTimetableModel.getTimes(), mTimetableModel.getWeeks().get(i)));
                            }
                            mView.onSuccess(mFragments);
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<TimetableModel> call, @NonNull Throwable t) {
                    if(isViewAttached()){
                        mView.hideLoadingIndicator();
                        mView.onFailure(t.getMessage());
                    }
                }
            });
        }
    }

    @Override
    public void bind(TimetableContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    private boolean isViewAttached(){
        return mView != null;
    }
}
