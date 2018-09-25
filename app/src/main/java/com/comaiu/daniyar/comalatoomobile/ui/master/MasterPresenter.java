package com.comaiu.daniyar.comalatoomobile.ui.master;

public class MasterPresenter implements MasterContract.Presenter {

    private MasterContract.View mView;

    MasterPresenter(){

    }

    @Override
    public void bind(MasterContract.View view) {
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
