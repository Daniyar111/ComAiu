package com.comaiu.daniyar.comalatoomobile.ui.master.overview;

public class MasterOverviewPresenter implements MasterOverviewContract.Presenter {

    private MasterOverviewContract.View mView;

    MasterOverviewPresenter(){

    }

    @Override
    public void bind(MasterOverviewContract.View view) {
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
