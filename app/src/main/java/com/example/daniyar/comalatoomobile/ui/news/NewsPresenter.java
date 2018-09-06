package com.example.daniyar.comalatoomobile.ui.news;

public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.View mView;

    NewsPresenter(){

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
