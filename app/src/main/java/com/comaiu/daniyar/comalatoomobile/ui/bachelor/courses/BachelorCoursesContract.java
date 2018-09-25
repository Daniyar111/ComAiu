package com.comaiu.daniyar.comalatoomobile.ui.bachelor.courses;

import com.comaiu.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.HashMap;
import java.util.List;

public interface BachelorCoursesContract {

    interface View{

        void updateCourses(HashMap<String, String> list, List<String> titles);
    }

    interface Presenter extends LifeCycle<View>{

        void updateData();
    }
}
