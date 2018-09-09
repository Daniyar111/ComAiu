package com.example.daniyar.comalatoomobile.ui.timetable.day;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.timetable.Week;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TimetableDayFragment extends BaseFragment implements TimetableDayContract.View, View.OnClickListener {

    private TimetableDayPresenter mPresenter;
    private TextView mTextViewDay, mTextViewOneA, mTextViewOneB, mTextViewTwo, mTextViewTwoA, mTextViewTwoB, mTextViewThree, mTextViewFour;
    private RecyclerView mRecyclerViewSubjects;
    private TimetableDayAdapter mAdapter;
    private String mDay;
    private Week mWeek;
    private ArrayList<String> mTimes;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_timetable_day;
    }

    public static TimetableDayFragment newInstance(String day, List<String> times, Week week){

        TimetableDayFragment fragment = new TimetableDayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("day", day);
        bundle.putStringArrayList("times", (ArrayList<String>) times);
        bundle.putParcelable("week", week);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new TimetableDayPresenter();
        mPresenter.bind(this);
        initializeViews(view);
        updateData();

    }

    private void initializeViews(View view){
        mTextViewDay = view.findViewById(R.id.textViewDay);
        mTextViewOneA = view.findViewById(R.id.textViewOneA);
        mTextViewOneB = view.findViewById(R.id.textViewOneB);
        mTextViewTwo = view.findViewById(R.id.textViewTwo);
        mTextViewTwoA = view.findViewById(R.id.textViewTwoA);
        mTextViewTwoB = view.findViewById(R.id.textViewTwoB);
        mTextViewThree = view.findViewById(R.id.textViewThree);
        mTextViewFour = view.findViewById(R.id.textViewFour);
        mRecyclerViewSubjects = view.findViewById(R.id.recyclerViewSubjects);
        mRecyclerViewSubjects.setLayoutManager(new LinearLayoutManager(getContext()));
        mTextViewOneA.setOnClickListener(this);
        mTextViewOneB.setOnClickListener(this);
        mTextViewTwo.setOnClickListener(this);
        mTextViewTwoA.setOnClickListener(this);
        mTextViewTwoB.setOnClickListener(this);
        mTextViewThree.setOnClickListener(this);
        mTextViewFour.setOnClickListener(this);
    }

    private void updateData(){
        if(getArguments() != null){
            mDay = getArguments().getString("day");
            mWeek = getArguments().getParcelable("week");
            mTimes = getArguments().getStringArrayList("times");

            mTextViewDay.setText(mDay);
            Log.d("DANITEXT", "onViewCreated: " + mWeek.toString());

            if(mWeek.getOneAS() != null){
                setTextData(mTextViewOneA, "1a");
            }
            if(mWeek.getOneBS() != null){
                setTextData(mTextViewOneB, "1b");
            }
            if(mWeek.getTwos() != null){
                setTextData(mTextViewTwo, "2");
            }
            if(mWeek.getTwoAS() != null){
                setTextData(mTextViewTwoA, "2a");
            }
            if(mWeek.getTwoBS() != null){
                setTextData(mTextViewTwoB, "2b");
            }
            if(mWeek.getThrees() != null){
                setTextData(mTextViewThree, "3");
            }
            if(mWeek.getFours() != null){
                setTextData(mTextViewFour, "4");
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textViewOneA:
                updateAdapter("1a");
                break;
            case R.id.textViewOneB:
                updateAdapter("1b");
                break;
            case R.id.textViewTwo:
                updateAdapter("2");
                break;
            case R.id.textViewTwoA:
                updateAdapter("2a");
                break;
            case R.id.textViewTwoB:
                updateAdapter("2b");
                break;
            case R.id.textViewThree:
                updateAdapter("3");
                break;
            case R.id.textViewFour:
                updateAdapter("4");
                break;
        }
    }

    private void updateAdapter(String grade){
        mAdapter = new TimetableDayAdapter(getContext(), mTimes, mWeek, grade);
        mRecyclerViewSubjects.setAdapter(mAdapter);
    }

    private void setTextData(TextView textView, String grade){
        textView.setText(grade);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
