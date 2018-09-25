package com.comaiu.daniyar.comalatoomobile.ui.exams;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.entity.TabPagerItem;
import com.comaiu.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.comaiu.daniyar.comalatoomobile.ui.BaseFragment;
import com.comaiu.daniyar.comalatoomobile.ui.FragmentPagerAdapter;

import java.util.ArrayList;

public class ExamsFragment extends BaseFragment implements ExamsContract.View{

    private ExamsPresenter mPresenter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_exams;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new ExamsPresenter(new ResourceManager(getContext()));
        mPresenter.bind(this);
        mViewPager = view.findViewById(R.id.viewPager);
        mTabLayout = view.findViewById(R.id.tabLayout);
        mPresenter.initViewPager();
    }

    @Override
    public void updateViewPager(ArrayList<TabPagerItem> tabPagerItems) {
        if(getActivity() != null){
            FragmentPagerAdapter adapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager(), tabPagerItems);
            mViewPager.setAdapter(adapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
