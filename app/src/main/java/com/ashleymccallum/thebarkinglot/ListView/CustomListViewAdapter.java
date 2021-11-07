package com.ashleymccallum.thebarkinglot.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ashleymccallum.thebarkinglot.R;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Resource> {
    public CustomListViewAdapter(@NonNull Context context, ArrayList<Resource> resource) {
        super(context, 0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resource_list, parent, false);
        }
        ImageView image = convertView.findViewById(R.id.resourceImage);
        TextView text = convertView.findViewById(R.id.resourceText);
        image.setImageResource(getItem(position).getImage());
        text.setText(getItem(position).getItem());
        return convertView;
    }
}
