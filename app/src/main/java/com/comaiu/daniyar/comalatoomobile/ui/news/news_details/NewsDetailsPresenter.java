package com.comaiu.daniyar.comalatoomobile.ui.news.news_details;

import com.comaiu.daniyar.comalatoomobile.data.entity.NewsModel;

import java.util.ArrayList;

public class NewsDetailsPresenter implements NewsDetailsContract.Presenter {

    private NewsDetailsContract.View mView;
    private ArrayList<NewsModel> mNewsModels;
    private int mPosition;

    NewsDetailsPresenter(){

    }

    @Override
    public void showButtons(ArrayList<NewsModel> newsModels, int position) {
        mNewsModels = newsModels;
        mPosition = position;
        if(mNewsModels.size() == 2){
            if(mPosition == 0 && isViewAttached()){
                mView.setInvisiblePrevious();
                mView.setVisibleNext();
                return;
            }
            if(mPosition == 1 && isViewAttached()){
                mView.setVisiblePrevious();
                mView.setVisibleNext();
            }
            return;
        }
        if(mNewsModels.size() == 1 && isViewAttached()){
            mView.setInvisiblePrevious();
            mView.setInvisibleNext();
        }
        else{
            if(mPosition == 0 && isViewAttached()){
                mView.setInvisiblePrevious();
                return;
            }
            if(mPosition == mNewsModels.size() - 1 && isViewAttached()){
                mView.setInvisibleNext();
            }
            else {
                if(isViewAttached()){
                    mView.setVisibleNext();
                    mView.setVisiblePrevious();
                }
            }
        }
    }

    @Override
    public void previousVacancy() {
        mPosition--;
        showButtons(mNewsModels, mPosition);
        if(isViewAttached()){
            mView.updateData(mNewsModels, mPosition);
        }
    }

    @Override
    public void nextVacancy() {
        mPosition++;
        showButtons(mNewsModels, mPosition);
        if(isViewAttached()){
            mView.updateData(mNewsModels, mPosition);
        }
    }

    @Override
    public void bind(NewsDetailsContract.View view) {
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
