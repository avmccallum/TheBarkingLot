package com.ashleymccallum.thebarkinglot.ListView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.ashleymccallum.thebarkinglot.R;
import com.google.android.material.snackbar.Snackbar;

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
        image.setImageResource(getItem(position).getResourceImage());
        text.setText(getItem(position).getResourceItem());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(text.getText() == getContext().getString(R.string.resource5)) {
                    Navigation.findNavController(view).navigate(R.id.action_nav_resources_to_nav_pet_info);
                } else {
                    Uri location = Uri.parse("geo:0,0?q=" + getItem(position).getResourceLink());
                    Intent i = new Intent(Intent.ACTION_VIEW, location);
                    Log.d("ResourceItem", location.toString());
                    try {
                        getContext().startActivity(i);
                    } catch (ActivityNotFoundException e) {
                        //TODO - make snackbar functional
//                        Snackbar.make(getContext().getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                    }
                }


            }
        });
        return convertView;
    }
}
