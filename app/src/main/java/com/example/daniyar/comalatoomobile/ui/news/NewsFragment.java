package com.example.daniyar.comalatoomobile.ui.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.NewsModel;
import com.example.daniyar.comalatoomobile.data.manager.ResourceManager;
import com.example.daniyar.comalatoomobile.ui.BaseFragment;
import com.example.daniyar.comalatoomobile.ui.news.news_details.NewsDetailsActivity;

import java.util.ArrayList;

public class NewsFragment extends BaseFragment implements NewsContract.View, OnNewsClickCallback {

    private NewsPresenter mPresenter;
    private RecyclerView mRecyclerViewNews;
    private NewsAdapter mAdapter;

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new NewsPresenter(new ResourceManager(getContext()));
        mPresenter.bind(this);
        initializeViews(view);
        mPresenter.initNewsList();
    }

    private void initializeViews(View view){
        mRecyclerViewNews = view.findViewById(R.id.recyclerViewNews);
        mRecyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void updateNewsList(ArrayList<NewsModel> newsModels) {
        mAdapter = new NewsAdapter(getContext(), newsModels, this);
        mRecyclerViewNews.setAdapter(mAdapter);
    }

    @Override
    public void onNewsClick(ArrayList<NewsModel> newsModels, int position) {
        Intent intent = new Intent(getContext(), NewsDetailsActivity.class);
        intent.putParcelableArrayListExtra("news_models", newsModels);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unbind();
    }
}
