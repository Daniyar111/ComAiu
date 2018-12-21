package com.comaiu.daniyar.comalatoomobile.ui.ams.ams_terms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.comaiu.daniyar.comalatoomobile.R;
import com.comaiu.daniyar.comalatoomobile.data.entity.ams.TermModel;

import java.util.ArrayList;

public class AmsAdapter extends RecyclerView.Adapter<AmsAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<TermModel> mTermModels;

    AmsAdapter(Context context, ArrayList<TermModel> termModels){
        mContext = context;
        mTermModels = termModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ams, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        updateData(viewHolder, mTermModels.get(position).getSubject(), mTermModels.get(position).getMidterm(), mTermModels.get(position).getFinal());
    }

    private void updateData(ViewHolder viewHolder, String subject, String midterm, String finalExam){
        viewHolder.mTextViewSubject.setText(subject);
        viewHolder.mTextViewMidterm.setText(midterm);
        viewHolder.mTextViewFinal.setText(finalExam);
    }

    @Override
    public int getItemCount() {
        return mTermModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextViewSubject, mTextViewMidterm, mTextViewFinal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewSubject = itemView.findViewById(R.id.textViewSubject);
            mTextViewMidterm = itemView.findViewById(R.id.textViewMidterm);
            mTextViewFinal = itemView.findViewById(R.id.textViewFinal);
        }
    }
}
