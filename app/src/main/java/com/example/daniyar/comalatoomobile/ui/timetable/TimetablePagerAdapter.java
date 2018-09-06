package com.example.daniyar.comalatoomobile.ui.timetable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.daniyar.comalatoomobile.data.entity.ViewPagerItem;

import java.util.ArrayList;

public class TimetablePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<ViewPagerItem> mViewPagerItems;

    public TimetablePagerAdapter(FragmentManager fm, ArrayList<ViewPagerItem> viewPagerItems) {
        super(fm);
        mViewPagerItems = viewPagerItems;
    }

    @Override
    public Fragment getItem(int position) {
        return mViewPagerItems.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mViewPagerItems.size();
    }
}
