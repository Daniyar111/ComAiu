package com.example.daniyar.comalatoomobile.ui.academ_calendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniyar.comalatoomobile.R;

import java.util.ArrayList;

public class AcademicCalendarAdapter extends RecyclerView.Adapter<AcademicCalendarAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<String> mNames;
    private ArrayList<String> mTerms;

    public AcademicCalendarAdapter(Context context, ArrayList<String> names, ArrayList<String> terms){
        mContext = context;
        mNames = names;
        mTerms = terms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(viewType == 1 ? R.layout.item_academic_calendar_odd : R.layout.item_academic_calendar_even, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mTextViewName.setText(mNames.get(position));
        holder.mTextViewTerm.setText(mTerms.get(position));
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextViewName, mTextViewTerm;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.textViewName);
            mTextViewTerm = itemView.findViewById(R.id.textViewTerm);
        }
    }
}
