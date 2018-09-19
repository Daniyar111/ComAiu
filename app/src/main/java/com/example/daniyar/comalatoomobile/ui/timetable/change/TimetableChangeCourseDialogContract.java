package com.example.daniyar.comalatoomobile.ui.timetable.change;

import com.example.daniyar.comalatoomobile.ui.LifeCycle;

public interface TimetableChangeCourseDialogContract {

    interface View{

        void setGradeFromDb(String grade);

        void setGrade();
    }

    interface Presenter extends LifeCycle<View>{

        void saveGrade(String grade);

        void checkGrade();
    }
}
