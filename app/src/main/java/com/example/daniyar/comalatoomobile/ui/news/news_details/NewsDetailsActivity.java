package com.example.daniyar.comalatoomobile.ui.news.news_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.NewsModel;
import com.example.daniyar.comalatoomobile.ui.BaseActivity;

import java.util.ArrayList;

public class NewsDetailsActivity extends BaseActivity implements NewsDetailsContract.View, View.OnClickListener {

    private NewsDetailsPresenter mPresenter;
    private LinearLayout mButtonPrevious, mButtonNext;
    private FrameLayout mFrameLayoutPrevious, mFrameLayoutNext;
    private TextView mTextViewPrevious, mTextViewNext, mTextViewName, mTextViewDate, mTextViewDescription;
    private ImageView mImageViewNews;

    @Override
    protected int getViewLayout() {
        return R.layout.activity_news_details;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());

        mPresenter = new NewsDetailsPresenter();
        mPresenter.bind(this);
        getToolbar(getResources().getString(R.string.title_news), true);

        initializeViews();
        getIntentData();
    }

    private void initializeViews(){
        mButtonPrevious = findViewById(R.id.buttonPrevious);
        mButtonNext = findViewById(R.id.buttonNext);
        mFrameLayoutPrevious = findViewById(R.id.frameLayoutPrevious);
        mFrameLayoutNext = findViewById(R.id.frameLayoutNext);
        mTextViewPrevious = findViewById(R.id.textViewPrevious);
        mTextViewNext = findViewById(R.id.textViewNext);
        mTextViewName = findViewById(R.id.textViewName);
        mTextViewDate = findViewById(R.id.textViewDate);
        mTextViewDescription = findViewById(R.id.textViewDescription);
        mImageViewNews = findViewById(R.id.imageViewNews);

        mButtonPrevious.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);
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

    private void getIntentData(){
        if(getIntent() != null){
            ArrayList<NewsModel> newsModels = getIntent().getParcelableArrayListExtra("news_models");
            int position = getIntent().getIntExtra("position", 0);
            updateData(newsModels, position);
            mPresenter.showButtons(newsModels, position);
        }
    }

    @Override
    public void updateData(ArrayList<NewsModel> newsModels, int position) {
        mTextViewName.setText(newsModels.get(position).getName());
        mTextViewDate.setText(newsModels.get(position).getDate());
        mTextViewDescription.setText(newsModels.get(position).getDescription());
        mImageViewNews.setImageResource(newsModels.get(position).getImageId());
    }

    @Override
    public void setInvisiblePrevious() {
        mFrameLayoutPrevious.setVisibility(View.INVISIBLE);
        mTextViewPrevious.setVisibility(View.INVISIBLE);
        mButtonPrevious.setClickable(false);
    }

    @Override
    public void setInvisibleNext() {
        mFrameLayoutNext.setVisibility(View.INVISIBLE);
        mTextViewNext.setVisibility(View.INVISIBLE);
        mButtonNext.setClickable(false);
    }

    @Override
    public void setVisiblePrevious() {
        mFrameLayoutPrevious.setVisibility(View.VISIBLE);
        mTextViewPrevious.setVisibility(View.VISIBLE);
        mButtonPrevious.setClickable(true);
    }

    @Override
    public void setVisibleNext() {
        mFrameLayoutNext.setVisibility(View.VISIBLE);
        mTextViewNext.setVisibility(View.VISIBLE);
        mButtonNext.setClickable(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonPrevious:
                mPresenter.previousVacancy();
                break;
            case R.id.buttonNext:
                mPresenter.nextVacancy();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }
}
