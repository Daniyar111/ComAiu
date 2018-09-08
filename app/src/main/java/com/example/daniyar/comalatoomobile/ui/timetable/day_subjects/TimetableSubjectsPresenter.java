package com.example.daniyar.comalatoomobile.ui.timetable.day_subjects;


public class TimetableSubjectsPresenter implements TimetableSubjectsContract.Presenter {

    private TimetableSubjectsContract.View mView;

    TimetableSubjectsPresenter(){

    }

    @Override
    public void bind(TimetableSubjectsContract.View view) {
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
