package com.example.daniyar.comalatoomobile.data.entity;

import android.support.v4.app.Fragment;

public class ViewPagerItem {

    private final Fragment mFragment;

    public ViewPagerItem(Fragment fragment){
        mFragment = fragment;
    }

    public Fragment getFragment() {
        return mFragment;
    }
}
