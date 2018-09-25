package com.comaiu.daniyar.comalatoomobile.ui.exams;

import com.comaiu.daniyar.comalatoomobile.data.entity.TabPagerItem;
import com.comaiu.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.ArrayList;

public interface ExamsContract {

    interface View{

        void updateViewPager(ArrayList<TabPagerItem> tabPagerItems);
    }

    interface Presenter extends LifeCycle<View>{

        void initViewPager();
    }
}
