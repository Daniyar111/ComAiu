package com.comaiu.daniyar.comalatoomobile.ui.bachelor;

public class BachelorPresenter implements BachelorContract.Presenter {

    private BachelorContract.View mView;

    BachelorPresenter(){

    }

    @Override
    public void bind(BachelorContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
