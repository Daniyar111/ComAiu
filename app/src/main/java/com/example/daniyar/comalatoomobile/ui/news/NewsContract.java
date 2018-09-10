package com.example.daniyar.comalatoomobile.ui.news;

import com.example.daniyar.comalatoomobile.data.entity.NewsModel;
import com.example.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.ArrayList;

public interface NewsContract {

    interface View{

        void updateNewsList(ArrayList<NewsModel> newsModels);
    }

    interface Presenter extends LifeCycle<View>{

        void initNewsList();
    }
}
