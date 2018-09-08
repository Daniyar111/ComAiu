package com.example.daniyar.comalatoomobile.data.entity;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

public class ViewPagerItem {

    private final Fragment mFragment;
    private final TimetableModel mTimetableModel;
    private final ArrayList<TimetableSubjectsModel> mSubjectsModels;

    public ViewPagerItem(Fragment fragment, TimetableModel timetableModel, ArrayList<TimetableSubjectsModel> subjectsModels){
        mFragment = fragment;
        mTimetableModel = timetableModel;
        mSubjectsModels = subjectsModels;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public TimetableModel getTimetableModel() {
        return mTimetableModel;
    }

    public ArrayList<TimetableSubjectsModel> getSubjectsModels() {
        return mSubjectsModels;
    }
}
