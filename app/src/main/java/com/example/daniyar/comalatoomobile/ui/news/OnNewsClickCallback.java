package com.example.daniyar.comalatoomobile.ui.news;

import com.example.daniyar.comalatoomobile.data.entity.NewsModel;

import java.util.ArrayList;

public interface OnNewsClickCallback {

    void onNewsClick(ArrayList<NewsModel> newsModels, int position);
}
