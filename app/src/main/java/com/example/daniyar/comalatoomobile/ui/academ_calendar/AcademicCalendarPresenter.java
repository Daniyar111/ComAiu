package com.example.daniyar.comalatoomobile.ui.academ_calendar;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.manager.ResourceManager;

import java.util.ArrayList;
import java.util.Arrays;

public class AcademicCalendarPresenter implements AcademicCalendarContract.Presenter {

    private AcademicCalendarContract.View mView;
    private ResourceManager mResourceManager;
    private ArrayList<String> mNames, mTerms;

    AcademicCalendarPresenter(ResourceManager resourceManager){
        mResourceManager = resourceManager;
        mNames = new ArrayList<>();
        mTerms = new ArrayList<>();
    }

    @Override
    public ArrayList<String> getNames() {
        String[] names = mResourceManager.getResources().getStringArray(R.array.academic_names);
        mNames.addAll(Arrays.asList(names));
        return mNames;
    }

    @Override
    public ArrayList<String> getTerms() {
        String[] terms = mResourceManager.getResources().getStringArray(R.array.academic_terms);
        mTerms.addAll(Arrays.asList(terms));
        return mTerms;
    }

    @Override
    public void bind(AcademicCalendarContract.View view) {
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
