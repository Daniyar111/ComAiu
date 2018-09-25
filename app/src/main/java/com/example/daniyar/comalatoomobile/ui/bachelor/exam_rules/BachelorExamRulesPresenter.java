package com.example.daniyar.comalatoomobile.ui.bachelor.exam_rules;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.manager.ResourceManager;

import java.util.ArrayList;
import java.util.Arrays;

public class BachelorExamRulesPresenter implements BachelorExamRulesContract.Presenter {

    private BachelorExamRulesContract.View mView;
    private ResourceManager mResourceManager;
    private ArrayList<String> mExams;

    BachelorExamRulesPresenter(ResourceManager resourceManager){
        mResourceManager = resourceManager;
        mExams = new ArrayList<>();
    }

    @Override
    public ArrayList<String> getData() {

        String[] exams = mResourceManager.getResources().getStringArray(R.array.bp_rules);
        mExams.addAll(Arrays.asList(exams));
        return mExams;
    }

    @Override
    public void bind(BachelorExamRulesContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
