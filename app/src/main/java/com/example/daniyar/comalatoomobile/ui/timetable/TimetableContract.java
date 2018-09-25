package com.example.daniyar.comalatoomobile.ui.timetable;

import android.support.v4.app.Fragment;
import com.example.daniyar.comalatoomobile.ui.IProgressBar;
import com.example.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.List;

public interface TimetableContract {

    interface View extends IProgressBar{

        void onSuccess(List<Fragment> fragments);

        void onFailure(String message);
    }

    interface Presenter extends LifeCycle<View>{

        void getTimetable();

        void getSavedTimetable();

        void getTimetableData();

        int getCurrentDay();
    }
}
