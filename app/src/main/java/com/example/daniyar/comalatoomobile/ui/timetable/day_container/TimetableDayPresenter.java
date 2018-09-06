package com.example.daniyar.comalatoomobile.ui.timetable.day_container;

public class TimetableDayPresenter implements TimetableDayContract.Presenter {

    private TimetableDayContract.View mView;

    TimetableDayPresenter(){

    }

    @Override
    public void bind(TimetableDayContract.View view) {
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
