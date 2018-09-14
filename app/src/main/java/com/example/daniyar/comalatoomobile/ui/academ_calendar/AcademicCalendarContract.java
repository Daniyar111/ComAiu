package com.example.daniyar.comalatoomobile.ui.academ_calendar;

import com.example.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.ArrayList;

public interface AcademicCalendarContract {

    interface View{

    }

    interface Presenter extends LifeCycle<View>{

        ArrayList<String> getNames();

        ArrayList<String> getTerms();
    }
}
