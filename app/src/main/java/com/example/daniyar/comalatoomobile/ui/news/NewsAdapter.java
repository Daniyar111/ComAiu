package com.example.daniyar.comalatoomobile.ui.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.NewsModel;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<NewsModel> mNewsModels;
    private OnNewsClickCallback mCallback;

    NewsAdapter(Context context, ArrayList<NewsModel> newsModels, OnNewsClickCallback callback){
        mContext = context;
        mNewsModels = newsModels;
        mCallback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.mTextViewDate.setText(mNewsModels.get(position).getDate());
        holder.mTextViewName.setText(mNewsModels.get(position).getName());
        holder.mImageViewNews.setImageResource(mNewsModels.get(position).getImageId());
        holder.mCardViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onNewsClick(mNewsModels, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextViewDate, mTextViewName;
        private ImageView mImageViewNews;
        private CardView mCardViewNews;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageViewNews = itemView.findViewById(R.id.imageViewNews);
            mTextViewDate =  itemView.findViewById(R.id.textViewDate);
            mTextViewName = itemView.findViewById(R.id.textViewName);
            mCardViewNews = itemView.findViewById(R.id.cardViewNews);
        }
    }
}
