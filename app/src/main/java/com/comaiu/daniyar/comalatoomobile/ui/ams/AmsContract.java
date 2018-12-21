package com.comaiu.daniyar.comalatoomobile.ui.ams;

import com.comaiu.daniyar.comalatoomobile.ui.IProgressBar;
import com.comaiu.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.ArrayList;

public interface AmsContract {

    interface View extends IProgressBar {

        void fillTheFields(String email, String password);

        void toastError(String message, String error);

        void toastText(String message);

        void goToMain();
    }

    interface Presenter extends LifeCycle<View> {

        void getLoginPass();

        void loginTo(String id, String pass);

        void onDestroy();
    }
}
