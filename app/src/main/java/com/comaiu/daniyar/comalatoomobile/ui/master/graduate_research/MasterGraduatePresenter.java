package com.comaiu.daniyar.comalatoomobile.ui.master.graduate_research;

public class MasterGraduatePresenter implements MasterGraduateContract.Presenter {

    private MasterGraduateContract.View mView;

    MasterGraduatePresenter(){

    }

    @Override
    public void bind(MasterGraduateContract.View view) {
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
