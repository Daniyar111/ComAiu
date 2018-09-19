package com.example.daniyar.comalatoomobile.ui.timetable.day;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniyar.comalatoomobile.ComApplication;
import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.timetable.Week;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;
import com.example.daniyar.comalatoomobile.ui.timetable.TimetableContractCallback;
import com.example.daniyar.comalatoomobile.ui.timetable.ViewPagerCallback;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class TimetableDayFragment extends BaseFragment implements TimetableDayContract.View, View.OnClickListener{

    private TimetableDayPresenter mPresenter;
    private TextView mTextViewDay, mTextViewOneA, mTextViewOneB, mTextViewTwo, mTextViewTwoA, mTextViewTwoB, mTextViewThree, mTextViewFour;
    private RecyclerView mRecyclerViewSubjects;
    private TimetableDayAdapter mAdapter;
    private String mDay;
    private Week mWeek;
    private RealmList<String> mTimes;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_timetable_day;
    }

    public static TimetableDayFragment newInstance(String day, ArrayList<String> times, Week week){

        TimetableDayFragment fragment = new TimetableDayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("day", day);
        Gson gson = new Gson();
        bundle.putStringArrayList("times", times);
        String weekJson = gson.toJson(week);
        bundle.putString("week", weekJson);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new TimetableDayPresenter(Realm.getDefaultInstance(), ComApplication.get(getContext()).getSQLiteHelper());
        mPresenter.bind(this);
        initializeViews(view);
        updateData();
        mPresenter.updateGradeTimetable(mWeek);
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
            Gson gson = new Gson();
            String weekJson = getArguments().getString("week");
            mWeek = gson.fromJson(weekJson, Week.class);
            RealmList<String> times = new RealmList<>();
            times.addAll(getArguments().getStringArrayList("times"));
            mTimes = times;

            mTextViewDay.setText(mDay);

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

    @Override
    public void updateAdapter(String grade){
        if(grade.equals("1a")){
            controlTextColor(R.color.colorBlue, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent);
        }
        if(grade.equals("1b")){
            controlTextColor(android.R.color.transparent, R.color.colorBlue, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent);
        }
        if(grade.equals("2")){
            controlTextColor(android.R.color.transparent, android.R.color.transparent, R.color.colorBlue, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent);
        }
        if(grade.equals("2a")){
            controlTextColor(android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, R.color.colorBlue, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent);
        }
        if(grade.equals("2b")){
            controlTextColor(android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, R.color.colorBlue, android.R.color.transparent, android.R.color.transparent);
        }
        if(grade.equals("3")){
            controlTextColor(android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, R.color.colorBlue, android.R.color.transparent);
        }
        if(grade.equals("4")){
            controlTextColor(android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, android.R.color.transparent, R.color.colorBlue);
        }
        mAdapter = new TimetableDayAdapter(getContext(), mTimes, mWeek, grade);
        mRecyclerViewSubjects.setAdapter(mAdapter);
    }

    private void setTextData(TextView textView, String grade){
        textView.setText(grade);
        textView.setVisibility(View.VISIBLE);
    }

    private void controlTextColor(int first, int second, int third, int forth, int fifth, int sixth, int seventh){
        mTextViewOneA.setBackgroundResource(first);
        mTextViewOneB.setBackgroundResource(second);
        mTextViewTwo.setBackgroundResource(third);
        mTextViewTwoA.setBackgroundResource(forth);
        mTextViewTwoB.setBackgroundResource(fifth);
        mTextViewThree.setBackgroundResource(sixth);
        mTextViewFour.setBackgroundResource(seventh);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
