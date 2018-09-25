package com.example.daniyar.comalatoomobile.ui.timetable.change;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.daniyar.comalatoomobile.ComApplication;
import com.example.daniyar.comalatoomobile.R;

public class TimetableChangeCourseDialogFragment extends DialogFragment implements TimetableChangeCourseDialogContract.View, RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private TimetableChangeCourseDialogPresenter mPresenter;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonFirstA, mRadioButtonFirstB, mRadioButtonSecondA, mRadioButtonSecondB, mRadioButtonThird, mRadioButtonForth, mCheckedRadioButton;
    private Button mButtonSelect, mButtonCancel;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_fragment_timetable_change_course, container, false);
        mPresenter = new TimetableChangeCourseDialogPresenter(ComApplication.get(getContext()).getSQLiteHelper());
        mPresenter.bind(this);
        initializeViews(view);
        removeDialogToolbarAndSetAnimation();
        mPresenter.checkGrade();
        return view;
    }


    private void initializeViews(View view){
        mRadioGroup = view.findViewById(R.id.radioGroup);
        mRadioButtonFirstA = view.findViewById(R.id.buttonFirstA);
        mRadioButtonFirstB = view.findViewById(R.id.buttonFirstB);
        mRadioButtonSecondA = view.findViewById(R.id.buttonSecondA);
        mRadioButtonSecondB = view.findViewById(R.id.buttonSecondB);
        mRadioButtonThird = view.findViewById(R.id.buttonThird);
        mRadioButtonForth = view.findViewById(R.id.buttonForth);
        mButtonCancel = view.findViewById(R.id.buttonCancel);
        mButtonSelect = view.findViewById(R.id.buttonSelect);
        mRadioGroup.setOnCheckedChangeListener(this);
        mButtonCancel.setOnClickListener(this);
        mButtonSelect.setOnClickListener(this);
    }

    private void removeDialogToolbarAndSetAnimation(){
        if(getDialog().getWindow() != null){
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogFragmentAnimation;
            getDialog().setCancelable(true);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        mCheckedRadioButton = radioGroup.findViewById(i);
    }

    @Override
    public void setGradeFromDb(String grade) {
        mRadioButtonFirstA.setChecked(grade.equals(mRadioButtonFirstA.getText().toString()));
        mRadioButtonFirstB.setChecked(grade.equals(mRadioButtonFirstB.getText().toString()));
        mRadioButtonSecondA.setChecked(grade.equals(mRadioButtonSecondA.getText().toString()));
        mRadioButtonSecondB.setChecked(grade.equals(mRadioButtonSecondB.getText().toString()));
        mRadioButtonThird.setChecked(grade.equals(mRadioButtonThird.getText().toString()));
        mRadioButtonForth.setChecked(grade.equals(mRadioButtonForth.getText().toString()));
    }

    @Override
    public void setGrade() {
        mRadioButtonFirstA.setChecked(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCancel:
                dismiss();
                break;
            case R.id.buttonSelect:
                mPresenter.saveGrade(mCheckedRadioButton.getText().toString());
                if(getTargetFragment() != null){
                    Intent intent = new Intent();
                    getTargetFragment().onActivityResult(getTargetRequestCode(), 1, intent);
                }
                dismiss();
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
