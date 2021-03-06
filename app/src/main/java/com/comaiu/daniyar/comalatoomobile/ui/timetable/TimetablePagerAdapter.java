package com.comaiu.daniyar.comalatoomobile.ui.timetable;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class TimetablePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public TimetablePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {

        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}
