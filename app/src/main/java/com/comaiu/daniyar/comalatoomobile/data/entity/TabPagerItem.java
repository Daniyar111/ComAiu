package com.comaiu.daniyar.comalatoomobile.data.entity;

import android.support.v4.app.Fragment;

public class TabPagerItem {

    private final Fragment mFragment;
    private final CharSequence mCharSequence;

    public TabPagerItem(Fragment fragment, CharSequence charSequence){
        mFragment = fragment;
        mCharSequence = charSequence;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public CharSequence getCharSequence() {
        return mCharSequence;
    }
}
