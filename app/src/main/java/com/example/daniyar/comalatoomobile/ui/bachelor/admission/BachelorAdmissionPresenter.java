package com.example.daniyar.comalatoomobile.ui.bachelor.admission;

public class BachelorAdmissionPresenter implements BachelorAdmissionContract.Presenter {

    private BachelorAdmissionContract.View mView;

    BachelorAdmissionPresenter(){

    }

    @Override
    public void bind(BachelorAdmissionContract.View view) {
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
