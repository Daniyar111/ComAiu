package com.comaiu.daniyar.comalatoomobile.ui.master.courses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.ui.BaseFragment;

public class MasterCoursesFragment extends BaseFragment implements MasterCoursesContract.View {

    private MasterCoursesPresenter mPresenter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_master_courses;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new MasterCoursesPresenter();
        mPresenter.bind(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
