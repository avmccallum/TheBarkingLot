package com.ashleymccallum.thebarkinglot.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ashleymccallum.thebarkinglot.R;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Credits> {

    public CustomListViewAdapter(@NonNull Context context, ArrayList<Credits> credits) {
        super(context, 0, credits);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview, parent, false);
        }
        TextView item = convertView.findViewById(R.id.creditItem);
        item.setText(getItem(position).getItem());
        TextView info = convertView.findViewById(R.id.creditInfo);
        info.setText(getItem(position).getCreditInfo());
        return convertView;
    }
}
