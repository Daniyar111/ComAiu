package com.example.daniyar.comalatoomobile.ui.timetable.change;

import android.util.Log;

import com.example.daniyar.comalatoomobile.data.db.SQLiteHelper;
import com.example.daniyar.comalatoomobile.data.entity.GradesModel;

public class TimetableChangeCourseDialogPresenter implements TimetableChangeCourseDialogContract.Presenter{

    private TimetableChangeCourseDialogContract.View mView;
    private SQLiteHelper mSQLiteHelper;
    private GradesModel mGradesModel;

    TimetableChangeCourseDialogPresenter(SQLiteHelper sqLiteHelper){
        mSQLiteHelper = sqLiteHelper;
        mGradesModel = new GradesModel();
    }

    @Override
    public void saveGrade(String grade) {
        mGradesModel.setGrade(grade);
        mSQLiteHelper.saveRadioButtons(mGradesModel);
    }

    @Override
    public void checkGrade() {
        if(mSQLiteHelper.getRadioButtons().getGrade() != null && isViewAttached()){
            mView.setGradeFromDb(mSQLiteHelper.getRadioButtons().getGrade());
        }
        else{
            mView.setGrade();
        }
    }

    @Override
    public void bind(TimetableChangeCourseDialogContract.View view) {
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
