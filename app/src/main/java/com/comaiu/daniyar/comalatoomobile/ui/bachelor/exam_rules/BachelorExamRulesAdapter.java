package com.comaiu.daniyar.comalatoomobile.ui.bachelor.exam_rules;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.comaiu.daniyar.comalatoomobile.R;

import java.util.ArrayList;

public class BachelorExamRulesAdapter extends RecyclerView.Adapter<BachelorExamRulesAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<String> mRules;

    public BachelorExamRulesAdapter(Context context, ArrayList<String> rules){
        mContext = context;
        mRules = rules;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(viewType == 1 ? R.layout.item_bachelor_exam_rules : R.layout.item_bachelor_exam_rules_second, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mTextViewRule.setText(mRules.get(position));
    }

    @Override
    public int getItemCount() {
        return mRules.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextViewRule;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewRule = itemView.findViewById(R.id.textViewRule);
        }
    }
}
