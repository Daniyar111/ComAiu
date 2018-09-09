package com.example.daniyar.comalatoomobile.ui.timetable;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.ViewPagerItem;
import com.example.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.example.daniyar.comalatoomobile.data.manager.RetrofitServiceManager;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TimetableFragment extends BaseFragment implements TimetableContract.View{

    private TimetablePresenter mPresenter;
    private ViewPager mViewPager;
    private TimetablePagerAdapter mAdapter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_timetable;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new TimetablePresenter(new RetrofitServiceManager(getContext()));
        mPresenter.bind(this);
        initializeViews(view);
        mPresenter.getTimetable();
    }

    private void initializeViews(View view){
        mViewPager = view.findViewById(R.id.viewPager);
    }

    @Override
    public void onSuccess(List<Fragment> fragments) {

        if(getActivity() != null){
            mAdapter = new TimetablePagerAdapter(getActivity().getSupportFragmentManager(), fragments);
            mViewPager.setAdapter(mAdapter);
        }
    }

    @Override
    public void onFailure(String message) {
        Log.d("SUCCESS_DAN", message);
    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
