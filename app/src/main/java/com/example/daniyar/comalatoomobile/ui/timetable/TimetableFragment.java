package com.example.daniyar.comalatoomobile.ui.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.daniyar.comalatoomobile.ComApplication;
import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.ViewPagerItem;
import com.example.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;
import com.example.daniyar.comalatoomobile.data.manager.RetrofitServiceManager;
import com.example.daniyar.comalatoomobile.data.manager.SystemServiceManager;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;
import com.example.daniyar.comalatoomobile.ui.timetable.change.TimetableChangeCourseDialogFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;

public class TimetableFragment extends BaseFragment implements TimetableContract.View, View.OnClickListener{

    private TimetablePresenter mPresenter;
    private ViewPager mViewPager;
    private TimetablePagerAdapter mAdapter;
    private Button mButtonUpdate, mButtonChange;
    private TimetableChangeCourseDialogFragment mDialogFragment;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_timetable;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new TimetablePresenter(new RetrofitServiceManager(getContext()), ComApplication.get(getContext()).getSQLiteHelper(), getActivity().getPreferences(Context.MODE_PRIVATE), new SystemServiceManager(getContext()), Realm.getDefaultInstance());
        mPresenter.bind(this);
        initializeViews(view);
        mPresenter.getTimetableData();
        Toast.makeText(getContext(), getResources().getString(R.string.swipe), Toast.LENGTH_LONG).show();

    }

    private void initializeViews(View view){
        mViewPager = view.findViewById(R.id.viewPager);
        mButtonChange = view.findViewById(R.id.buttonChange);
        mButtonUpdate = view.findViewById(R.id.buttonUpdate);
        mButtonUpdate.setOnClickListener(this);
        mButtonChange.setOnClickListener(this);
    }

    @Override
    public void onSuccess(List<Fragment> fragments) {

        if(getActivity() != null){
            mAdapter = new TimetablePagerAdapter(getActivity().getSupportFragmentManager(), fragments);
            mViewPager.setAdapter(mAdapter);
            mViewPager.setCurrentItem(mPresenter.getCurrentDay());
        }
    }

    @Override
    public void onFailure(String message) {
        Log.d("SUCCESS_DAN", message);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.buttonChange:
                if(getActivity() != null){
                    mDialogFragment = new TimetableChangeCourseDialogFragment();
                    mDialogFragment.show(getActivity().getSupportFragmentManager(), "fragment");
                    mDialogFragment.setTargetFragment(TimetableFragment.this, 1);
                }
                break;
            case R.id.buttonUpdate:
                mPresenter.getTimetable();
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            Log.d("ACTIVITYDANI", "here");
            mAdapter.notifyDataSetChanged();
        }
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
