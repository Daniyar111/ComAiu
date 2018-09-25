package com.comaiu.daniyar.comalatoomobile.ui.news;

import android.util.Log;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.entity.NewsModel;
import com.comaiu.daniyar.comalatoomobile.data.manager.ResourceManager;

import java.util.ArrayList;

public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.View mView;
    private ResourceManager mResourceManager;
    private ArrayList<NewsModel> mNewsModels;

    NewsPresenter(ResourceManager resourceManager){
        mResourceManager = resourceManager;
        mNewsModels = new ArrayList<>();
    }

    @Override
    public void initNewsList() {
        String[] newsDate = mResourceManager.getResources().getStringArray(R.array.news_date);
        String[] newsName = mResourceManager.getResources().getStringArray(R.array.news_name);
        String[] newsDescription = mResourceManager.getResources().getStringArray(R.array.news_description);

        Log.d("DANIRECY", newsDate.length + " " + newsName.length + " " + newsDescription.length);
        for (int i = 0; i < newsDate.length; i++) {
            NewsModel newsModel = new NewsModel();
            newsModel.setDate(newsDate[i]);
            newsModel.setName(newsName[i]);
            newsModel.setDescription(newsDescription[i]);
            newsModel.setImageId(imagesArray()[i]);
            mNewsModels.add(newsModel);
        }
        if(isViewAttached()){
            mView.updateNewsList(mNewsModels);
        }
    }

    private int[] imagesArray(){

        return new int[]{R.drawable.news01, R.drawable.news02, R.drawable.news03, R.drawable.news04, R.drawable.news05,
                R.drawable.news06, R.drawable.news07, R.drawable.news08, R.drawable.news09, R.drawable.news10};
    }

    @Override
    public void bind(NewsContract.View view) {
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
