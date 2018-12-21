package com.comaiu.daniyar.comalatoomobile.ui.ams.ams_terms;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.entity.ams.YearAmsModel;
import com.comaiu.daniyar.comalatoomobile.ui.BaseActivity;

public class AmsTermsActivity extends BaseActivity implements AmsTermsContract.View, AdapterView.OnItemSelectedListener {

    private AmsTermsPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private Spinner mSpinner;
    private TextView mTextViewYear;
    private AmsAdapter mAmsAdapter;
    private RelativeLayout mProgressBar;
    private LinearLayout mLayoutNotProgress;
    private RelativeLayout mTextViewNotStudy;

    @Override
    protected int getViewLayout() {
        return R.layout.activity_ams_terms;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());

        mPresenter = new AmsTermsPresenter();
        mPresenter.bind(this);
        getToolbar("University Management System", false);
        initializeViews();
        mPresenter.initStudyYears();
        mSpinner.setAdapter(new SpinnerAdapter(this, mPresenter.getStudyYears()));
        mSpinner.setOnItemSelectedListener(this);
        mPresenter.selectSpinner();
    }

    private void initializeViews(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSpinner = findViewById(R.id.spinner);
        mTextViewYear = findViewById(R.id.textViewYear);
        mProgressBar = findViewById(R.id.progressBar);
        mTextViewNotStudy = findViewById(R.id.textViewNotStudy);
        mLayoutNotProgress = findViewById(R.id.layoutNotProgress);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_exit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_item_ams:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedItemText = (String) adapterView.getItemAtPosition(i);
        mPresenter.getScore(selectedItemText.split(" ")[0], selectedItemText.split(" ")[1]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void updateAdapter(YearAmsModel yearAmsModel){
        mTextViewYear.setText(yearAmsModel.getYear());
        mAmsAdapter = new AmsAdapter(this, yearAmsModel.getTermModels());
        mRecyclerView.setAdapter(mAmsAdapter);
    }

    @Override
    public void selectLastSpinner() {
        mSpinner.setSelection(mPresenter.getStudyYears().size() - 1);
    }

    @Override
    public void selectPreLastSpinner() {
        mSpinner.setSelection(mPresenter.getStudyYears().size() - 2);
    }

    @Override
    public void onFailure() {
        mLayoutNotProgress.setVisibility(View.GONE);
        mTextViewNotStudy.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess() {
        mTextViewNotStudy.setVisibility(View.GONE);
        mLayoutNotProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadingIndicator() {
    }

    @Override
    public void hideLoadingIndicator() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mPresenter.unbind();
    }
}
