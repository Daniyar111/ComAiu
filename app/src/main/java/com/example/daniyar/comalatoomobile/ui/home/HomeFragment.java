package com.example.daniyar.comalatoomobile.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

public class HomeFragment extends BaseFragment implements  HomeContract.View{

    private HomePresenter mPresenter;
    private ViewFlipper mViewFlipper;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new HomePresenter();
        mPresenter.bind(this);

        flipImages(view);
    }

    private void flipImages(View view){
        mViewFlipper = view.findViewById(R.id.imageFlipper);
        mViewFlipper.setFlipInterval(3000);
        mViewFlipper.setInAnimation(getContext(), R.anim.left_to_center);
        mViewFlipper.setOutAnimation(getContext(), R.anim.center_to_right);
        mViewFlipper.startFlipping();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewFlipper.stopFlipping();
        mPresenter.unbind();
    }
}
