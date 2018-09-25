package com.comaiu.daniyar.comalatoomobile.ui.news.news_details;

import com.comaiu.daniyar.comalatoomobile.data.entity.NewsModel;
import com.comaiu.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.ArrayList;

public interface NewsDetailsContract {

    interface View{

        void updateData(ArrayList<NewsModel> newsModels, int position);

        void setInvisiblePrevious();

        void setInvisibleNext();

        void setVisiblePrevious();

        void setVisibleNext();
    }

    interface Presenter extends LifeCycle<View>{

        void showButtons(ArrayList<NewsModel> newsModels, int position);

        void previousVacancy();

        void nextVacancy();
    }
}
