package com.comaiu.daniyar.comalatoomobile.ui.academ_calendar;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.comaiu.daniyar.comalatoomobile.ui.BaseActivity;
public class AcademicCalendarActivity extends BaseActivity implements AcademicCalendarContract.View {

    private AcademicCalendarPresenter mPresenter;
    private RecyclerView mRecyclerViewCalendar;
    private AcademicCalendarAdapter mAdapter;
    private TextView mTextViewName;

    @Override
    protected int getViewLayout() {
        return R.layout.activity_academic_calendar;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());

        mPresenter = new AcademicCalendarPresenter(new ResourceManager(this));
        mPresenter.bind(this);

        getToolbar(getResources().getString(R.string.academic_calendar), true);

        initializeViews();
    }

    private void initializeViews(){
        mTextViewName = findViewById(R.id.textViewName);
        mRecyclerViewCalendar = findViewById(R.id.recyclerViewCalendar);
        mTextViewName.setText(getResources().getString(R.string.academic_calendar_2018_2019));
        mRecyclerViewCalendar.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AcademicCalendarAdapter(this, mPresenter.getNames(), mPresenter.getTerms());
        mRecyclerViewCalendar.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }
}
