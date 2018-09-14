package com.example.daniyar.comalatoomobile.ui.master.admission;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

public class MasterAdmissionFragment extends BaseFragment implements MasterAdmissionContract.View {

    private MasterAdmissionPresenter mPresenter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_master_admission;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new MasterAdmissionPresenter();
        mPresenter.bind(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
