package com.comaiu.daniyar.comalatoomobile.ui.master.graduate_research;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.ui.BaseFragment;

public class MasterGraduateFragment extends BaseFragment implements MasterGraduateContract.View {

    private MasterGraduatePresenter mPresenter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_master_graduate_research;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new MasterGraduatePresenter();
        mPresenter.bind(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
