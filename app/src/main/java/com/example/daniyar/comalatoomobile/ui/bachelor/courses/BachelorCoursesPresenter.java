package com.example.daniyar.comalatoomobile.ui.bachelor.courses;

import android.util.Log;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.BachelorCoursesModel;
import com.example.daniyar.comalatoomobile.data.manager.ResourceManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BachelorCoursesPresenter implements BachelorCoursesContract.Presenter {

    private BachelorCoursesContract.View mView;
    private ResourceManager mResourceManager;
    private HashMap<String, String> mDescriptions;
    private List<String> mTitles;

    BachelorCoursesPresenter(ResourceManager resourceManager){
        mResourceManager = resourceManager;
        mDescriptions = new HashMap<>();
    }

    @Override
    public void updateData() {
        String[] coursesName = mResourceManager.getResources().getStringArray(R.array.bp_courses);
        String[] coursesDescription = mResourceManager.getResources().getStringArray(R.array.bp_courses_description);

        for (int i = 0; i < coursesName.length; i++) {
            mDescriptions.put(coursesName[i], coursesDescription[i]);
        }
        mTitles = new ArrayList<>(mDescriptions.keySet());
        Collections.sort(mTitles);
        Log.d("DANIHASH", mTitles.toString());

        if(isViewAttached()){
            mView.updateCourses(mDescriptions, mTitles);
        }
    }

    @Override
    public void bind(BachelorCoursesContract.View view) {
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
