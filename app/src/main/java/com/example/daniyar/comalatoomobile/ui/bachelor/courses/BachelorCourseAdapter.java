package com.example.daniyar.comalatoomobile.ui.bachelor.courses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniyar.comalatoomobile.R;
import com.example.daniyar.comalatoomobile.ui.custom_views.AnimatedExpandableListView;

import java.util.HashMap;
import java.util.List;

public class BachelorCourseAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

    private Context mContext;
    private List<String> mTitles;
    private HashMap<String, String> mDescription;

    public BachelorCourseAdapter(Context context, List<String> titles, HashMap<String, String> descriptions){
        mContext = context;
        mTitles = titles;
        mDescription = descriptions;

    }

    @Override
    public int getGroupCount() {
        return mTitles.size();
    }

    @Override
    public Object getGroup(int i) {
        return mTitles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mDescription.get(mTitles.get(i));
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String listTitle = (String) getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(inflater != null)
                view = inflater.inflate(R.layout.item_bachelor_courses_group, null);
        }
        if(view != null){
            TextView textViewTitle = view.findViewById(R.id.textViewName);
            textViewTitle.setText(listTitle);
        }

        return view;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater != null)
                convertView = inflater.inflate(R.layout.item_bachelor_courses_child, null);
        }

        TextView expandedTextView = convertView.findViewById(R.id.textViewDescription);
        expandedTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
