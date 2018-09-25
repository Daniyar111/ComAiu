package com.example.daniyar.comalatoomobile.ui.home;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    HomePresenter(){

    }

    @Override
    public void bind(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
