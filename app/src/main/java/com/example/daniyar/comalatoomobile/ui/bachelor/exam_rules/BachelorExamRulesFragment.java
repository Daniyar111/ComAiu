package com.example.daniyar.comalatoomobile.ui.bachelor.exam_rules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

public class BachelorExamRulesFragment extends BaseFragment implements BachelorExamRulesContract.View {

    private BachelorExamRulesPresenter mPresenter;
    private RecyclerView mRecyclerViewExams;
    private BachelorExamRulesAdapter mAdapter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_bachelor_exam_rules;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new BachelorExamRulesPresenter(new ResourceManager(getContext()));
        mPresenter.bind(this);
        initializeViews(view);
    }

    private void initializeViews(View view){
        mRecyclerViewExams = view.findViewById(R.id.recyclerViewExam);
        mRecyclerViewExams.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new BachelorExamRulesAdapter(getContext(), mPresenter.getData());
        mRecyclerViewExams.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
