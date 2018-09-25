package com.example.daniyar.comalatoomobile.ui.timetable.day;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.timetable.Week;

import java.util.ArrayList;

public class TimetableDayAdapter extends RecyclerView.Adapter<TimetableDayAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mTimes;
    private Week mWeek;
    private String mGrade;

    TimetableDayAdapter(Context context, ArrayList<String> times, Week week, String grade){
        mContext = context;
        mTimes = times;
        mWeek = week;
        mGrade = grade;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timetable_subjects, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(mGrade.equals("1a") && mWeek.getOneAS() != null){
            updateTextData(holder, mTimes.get(position), mWeek.getOneAS().get(position).getName(), mWeek.getOneAS().get(position).getOther());
            return;
        }
        if(mGrade.equals("1b") && mWeek.getOneBS() != null){
            updateTextData(holder, mTimes.get(position), mWeek.getOneBS().get(position).getName(), mWeek.getOneBS().get(position).getOther());
            return;
        }
        if(mGrade.equals("2") && mWeek.getTwos() != null){
            updateTextData(holder, mTimes.get(position), mWeek.getTwos().get(position).getName(), mWeek.getTwos().get(position).getOther());
            return;
        }
        if(mGrade.equals("2a") && mWeek.getTwoAS() != null){
            updateTextData(holder, mTimes.get(position), mWeek.getTwoAS().get(position).getName(), mWeek.getTwoAS().get(position).getOther());
            return;
        }
        if(mGrade.equals("2b") && mWeek.getTwoBS() != null){
            updateTextData(holder, mTimes.get(position), mWeek.getTwoBS().get(position).getName(), mWeek.getTwoBS().get(position).getOther());
            return;
        }
        if(mGrade.equals("3") && mWeek.getThrees() != null){
            updateTextData(holder, mTimes.get(position), mWeek.getThrees().get(position).getName(), mWeek.getThrees().get(position).getOther());
            return;
        }
        if(mGrade.equals("4") && mWeek.getFours() != null){
            updateTextData(holder, mTimes.get(position), mWeek.getFours().get(position).getName(), mWeek.getFours().get(position).getOther());
        }
    }

    @Override
    public int getItemCount() {
        return mTimes.size();
    }

    private void updateTextData(ViewHolder holder, String time, String subject, String teacher){
        if(time.equals("")){
            holder.mTextViewTime.setText(mContext.getString(R.string.lunch));
        }
        else{
            holder.mTextViewTime.setText(time);
        }
        filterText(holder.mTextViewSubject, subject);
        filterText(holder.mTextViewTeacher, teacher);
    }

    private void filterText(TextView textView, String text){
        if(text.contains("&amp;")){
            textView.setText(text.replace("&amp;", "&"));
        }
        else if(text.contains("&#39;")){
            textView.setText(text.replace("&#39;", "'"));
        }
        else{
            textView.setText(text);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextViewTime, mTextViewSubject, mTextViewTeacher;

        ViewHolder(View itemView) {
            super(itemView);
            mTextViewTime = itemView.findViewById(R.id.textViewTime);
            mTextViewSubject = itemView.findViewById(R.id.textViewSubject);
            mTextViewTeacher = itemView.findViewById(R.id.textViewTeacher);
        }
    }
}
