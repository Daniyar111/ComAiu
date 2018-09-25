package com.example.daniyar.comalatoomobile.ui.main;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    MainPresenter(){

    }

    @Override
    public void bind(MainContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
