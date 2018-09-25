package com.comaiu.daniyar.comalatoomobile.ui.master.admission;

public class MasterAdmissionPresenter implements MasterAdmissionContract.Presenter {

    private MasterAdmissionContract.View mView;

    MasterAdmissionPresenter(){

    }

    @Override
    public void bind(MasterAdmissionContract.View view) {
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
