package com.example.daniyar.comalatoomobile.ui.bachelor.courses;

import com.example.daniyar.comalatoomobile.data.entity.BachelorCoursesModel;
import com.example.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface BachelorCoursesContract {

    interface View{

        void updateCourses(HashMap<String, String> list, List<String> titles);
    }

    interface Presenter extends LifeCycle<View>{

        void updateData();
    }
}
