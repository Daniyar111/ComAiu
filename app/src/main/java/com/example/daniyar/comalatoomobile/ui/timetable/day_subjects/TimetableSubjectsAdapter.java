package com.example.daniyar.comalatoomobile.ui.timetable.day_subjects;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.data.entity.TimetableSubjectsModel;

import java.util.ArrayList;

public class TimetableSubjectsAdapter extends RecyclerView.Adapter<TimetableSubjectsAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<TimetableSubjectsModel> mSubjectsModels;
    private TimetableSubjectsModel mSubjectsModel;

    TimetableSubjectsAdapter(Context context, ArrayList<TimetableSubjectsModel> subjectsModels){
        mContext = context;
        mSubjectsModels = subjectsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timetable_subjects, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        mSubjectsModel = mSubjectsModels.get(position);
        holder.mTextViewTime.setText(mSubjectsModel.getTime());
        holder.mTextViewSubject.setText(mSubjectsModel.getSubject());
        holder.mTextViewTeacher.setText(mSubjectsModel.getTeacher());
        holder.mTextViewRoom.setText(mSubjectsModel.getRoom());
    }

    @Override
    public int getItemCount() {
        return mSubjectsModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextViewTime, mTextViewSubject, mTextViewTeacher, mTextViewRoom;

        ViewHolder(View itemView) {
            super(itemView);
            mTextViewTime = itemView.findViewById(R.id.textViewTime);
            mTextViewSubject = itemView.findViewById(R.id.textViewSubject);
            mTextViewTeacher = itemView.findViewById(R.id.textViewTeacher);
            mTextViewRoom = itemView.findViewById(R.id.textViewRoom);
        }
    }
}
