package com.example.daniyar.comalatoomobile.ui.bachelor.courses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.ui.custom_views.AnimatedExpandableListView;
import com.example.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

import java.util.HashMap;
import java.util.List;

public class BachelorCoursesFragment extends BaseFragment implements BachelorCoursesContract.View, ExpandableListView.OnGroupClickListener {

    private BachelorCoursesPresenter mPresenter;
    private AnimatedExpandableListView mExpandableListView;
    private BachelorCourseAdapter mAdapter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_bachelor_courses;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new BachelorCoursesPresenter(new ResourceManager(getContext()));
        mPresenter.bind(this);
        initializeViews(view);
        mPresenter.updateData();
    }

    private void initializeViews(View view){
        mExpandableListView = view.findViewById(R.id.expandableListView);
    }

    @Override
    public void updateCourses(HashMap<String, String> list, List<String> titles) {
        mAdapter = new BachelorCourseAdapter(getContext(), titles, list);
        mExpandableListView.setAdapter(mAdapter);
        mExpandableListView.setOnGroupClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }

    @Override
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

        if(mExpandableListView.isGroupExpanded(i)){
            mExpandableListView.collapseGroupWithAnimation(i);
        }
        else{
            mExpandableListView.expandGroupWithAnimation(i);
        }
        return true;
    }
}
