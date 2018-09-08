package com.example.daniyar.comalatoomobile.ui.timetable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.ViewPagerItem;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

import java.util.ArrayList;

public class TimetableFragment extends BaseFragment implements TimetableContract.View{

    private TimetablePresenter mPresenter;
    private ArrayList<ViewPagerItem> mViewPagerItems;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_timetable;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new TimetablePresenter();
        mPresenter.bind(this);

        mViewPagerItems = new ArrayList<>();
//        mViewPagerItems.add(new ViewPagerItem())
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
