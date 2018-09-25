package com.example.daniyar.comalatoomobile.ui.timetable.day;

import com.example.daniyar.comalatoomobile.data.entity.timetable.Week;
import com.example.daniyar.comalatoomobile.ui.LifeCycle;

public interface TimetableDayContract {

    interface View{

        void updateAdapter(String grade);
    }

    interface Presenter extends LifeCycle<View>{

        void updateGradeTimetable(Week week);
    }
}
