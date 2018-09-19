package com.example.daniyar.comalatoomobile.ui.exams;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.TabPagerItem;
import com.example.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.example.daniyar.comalatoomobile.ui.exams.final_exams.ExamsFinalFragment;
import com.example.daniyar.comalatoomobile.ui.exams.midterm.ExamsMidtermFragment;

import java.util.ArrayList;

public class ExamsPresenter implements ExamsContract.Presenter {

    private ExamsContract.View mView;
    private ResourceManager mResourceManager;

    ExamsPresenter(ResourceManager resourceManager){
        mResourceManager = resourceManager;
    }

    @Override
    public void initViewPager() {
        ArrayList<TabPagerItem> tabPagerItems = new ArrayList<>();
        tabPagerItems.add(new TabPagerItem(new ExamsMidtermFragment(), mResourceManager.getResources().getString(R.string.title_midterm)));
        tabPagerItems.add(new TabPagerItem(new ExamsFinalFragment(), mResourceManager.getResources().getString(R.string.title_final)));
        if(isViewAttached()){
            mView.updateViewPager(tabPagerItems);
        }
    }

    @Override
    public void bind(ExamsContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    private boolean isViewAttached(){
        return mView != null;
    }
}
