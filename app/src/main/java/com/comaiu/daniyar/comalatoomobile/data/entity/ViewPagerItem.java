package com.comaiu.daniyar.comalatoomobile.data.entity;

import android.support.v4.app.Fragment;

import com.comaiu.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.comaiu.daniyar.comalatoomobile.data.entity.timetable.Week;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerItem {

    private final Fragment mFragment;
    private final List<String> mTimes;
    private final Week mWeek;

    public ViewPagerItem(Fragment fragment, List<String> times, Week week){
        mFragment = fragment;
        mTimes = times;
        mWeek = week;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public List<String> getTimes() {
        return mTimes;
    }

    public Week getWeek() {
        return mWeek;
    }
}
