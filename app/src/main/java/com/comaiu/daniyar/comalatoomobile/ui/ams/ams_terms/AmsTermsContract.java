package com.comaiu.daniyar.comalatoomobile.ui.ams.ams_terms;

import com.comaiu.daniyar.comalatoomobile.data.entity.ams.YearAmsModel;
import com.comaiu.daniyar.comalatoomobile.ui.IProgressBar;
import com.comaiu.daniyar.comalatoomobile.ui.LifeCycle;

import java.util.ArrayList;

public interface AmsTermsContract {

    interface View extends IProgressBar {

        void updateAdapter(YearAmsModel yearAmsModel);

        void selectLastSpinner();

        void selectPreLastSpinner();

        void onFailure();

        void onSuccess();
    }

    interface Presenter extends LifeCycle<View> {

        void getScore(String year, String term);

        void initAllStudyYears();

        void initStudyYears();

        void selectSpinner();

        ArrayList<String> getStudyYears();

        void onDestroy();
    }
}
