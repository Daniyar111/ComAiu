package com.example.daniyar.comalatoomobile.ui.bachelor.admission;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

public class BachelorAdmissionFragment extends BaseFragment implements BachelorAdmissionContract.View{

    private BachelorAdmissionPresenter mPresenter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_bachelor_admission;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new BachelorAdmissionPresenter();
        mPresenter.bind(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}