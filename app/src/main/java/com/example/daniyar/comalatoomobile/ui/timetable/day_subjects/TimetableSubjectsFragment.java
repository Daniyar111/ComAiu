package com.example.daniyar.comalatoomobile.ui.timetable.day_subjects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

public class TimetableSubjectsFragment extends BaseFragment implements TimetableSubjectsContract.View{

    private TimetableSubjectsPresenter mPresenter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_timetable_day;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new TimetableSubjectsPresenter();
        mPresenter.bind(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
