package com.example.daniyar.comalatoomobile.ui.bachelor.exam_rules;

import com.example.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.ArrayList;

public interface BachelorExamRulesContract {

    interface View{

    }

    interface Presenter extends LifeCycle<View>{

        ArrayList<String> getData();
    }
}
