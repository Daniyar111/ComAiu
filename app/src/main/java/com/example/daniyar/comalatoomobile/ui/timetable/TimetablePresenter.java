package com.example.daniyar.comalatoomobile.ui.timetable;

public class TimetablePresenter implements TimetableContract.Presenter {

    private TimetableContract.View mView;

    TimetablePresenter(){

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
