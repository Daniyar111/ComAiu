package com.example.daniyar.comalatoomobile.ui.timetable.day;

import com.example.daniyar.comalatoomobile.data.db.SQLiteHelper;
import com.example.daniyar.comalatoomobile.data.entity.timetable.Week;


public class TimetableDayPresenter implements TimetableDayContract.Presenter {

    private TimetableDayContract.View mView;
    private SQLiteHelper mSQLiteHelper;
    private String mGrade;

    TimetableDayPresenter(SQLiteHelper sqLiteHelper){
        mSQLiteHelper = sqLiteHelper;
    }

    @Override
    public void updateGradeTimetable(Week week) {

        if(mSQLiteHelper.getRadioButtons().getGrade() != null){
            mGrade = mSQLiteHelper.getRadioButtons().getGrade();
            switch (mGrade){
                case "1st - A":
                    if(week.getOneAS() != null && isViewAttached()){
                        mView.updateAdapter("1a");
                    }
                    break;
                case "1st - B":
                    if(week.getOneBS() != null && isViewAttached()){
                        mView.updateAdapter("1b");
                    }
                    break;
                case "2nd - A":
                    if(week.getTwos() != null && isViewAttached()){
                        mView.updateAdapter("2");
                        return;
                    }
                    if(week.getTwoAS() != null && isViewAttached()){
                        mView.updateAdapter("2a");
                    }
                    break;
                case "2nd - B":
                    if(week.getTwos() != null && isViewAttached()){
                        mView.updateAdapter("2");
                        return;
                    }
                    if(week.getTwoBS() != null && isViewAttached()){
                        mView.updateAdapter("2b");
                    }
                    break;
                case "3rd":
                    if(week.getThrees() != null && isViewAttached()){
                        mView.updateAdapter("3");
                    }
                    break;
                case "4th":
                    if(week.getFours() != null && isViewAttached()){
                        mView.updateAdapter("4");
                    }
                    break;
            }
        }
        else {
            if(isViewAttached()) mView.updateAdapter("1a");
        }
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
