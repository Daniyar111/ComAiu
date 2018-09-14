package com.example.daniyar.comalatoomobile.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.daniyar.comalatoomobile.data.entity.TabPagerItem;

import java.util.ArrayList;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<TabPagerItem> mTabPagerItems;

    public FragmentPagerAdapter(FragmentManager fm, ArrayList<TabPagerItem> tabPagerItems) {
        super(fm);
        mTabPagerItems = tabPagerItems;
    }

    @Override
    public Fragment getItem(int position) {
        return mTabPagerItems.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mTabPagerItems.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabPagerItems.get(position).getCharSequence();
    }
}
