package com.comaiu.daniyar.comalatoomobile.ui.timetable.day;

import com.comaiu.daniyar.comalatoomobile.data.entity.timetable.Week;
import com.comaiu.daniyar.comalatoomobile.ui.LifeCycle;

public interface TimetableDayContract {

    interface View{

        void updateAdapter(String grade);
    }

    interface Presenter extends LifeCycle<View>{

        void updateGradeTimetable(Week week);
    }
}
