package com.comaiu.daniyar.comalatoomobile.ui.exams;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.entity.TabPagerItem;
import com.comaiu.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.comaiu.daniyar.comalatoomobile.ui.exams.final_exams.ExamsFinalFragment;
import com.comaiu.daniyar.comalatoomobile.ui.exams.midterm.ExamsMidtermFragment;

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
