package com.comaiu.daniyar.comalatoomobile.ui.master.courses;

public class MasterCoursesPresenter implements MasterCoursesContract.Presenter {

    private MasterCoursesContract.View mView;

    MasterCoursesPresenter(){

    }

    @Override
    public void bind(MasterCoursesContract.View view) {
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
