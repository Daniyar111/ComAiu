package com.comaiu.daniyar.comalatoomobile.ui.ams.ams_terms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.comaiu.daniyar.comalatoomobile.R;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {

    private ArrayList<String> mTerms;
    private Context mContext;

    public SpinnerAdapter(Context context, ArrayList<String> terms){
        mContext = context;
        mTerms = terms;
    }

    @Override
    public int getCount() {
        return mTerms.size();
    }

    @Override
    public Object getItem(int i) {
        return mTerms.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_spinner, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        String spinner = (String) getItem(i);
        viewHolder.mTextView.setText(spinner);

        return view;
    }

    public class ViewHolder{

        private TextView mTextView;
        ViewHolder(View view){
            mTextView = view.findViewById(R.id.textView);
        }
    }
}
