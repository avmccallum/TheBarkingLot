package com.ashleymccallum.thebarkinglot.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashleymccallum.thebarkinglot.R;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> implements View.OnClickListener {
    private ArrayList<PetInfo> pets;

    public CustomRecyclerViewAdapter(ArrayList<PetInfo> pets) {
        this.pets = pets;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_info_recycler, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        PetInfo pet = pets.get(position);
        holder.petName.setText(pet.getPetName());
        holder.petImage.setImageResource(pet.getPetImage());
    }

    @Override
    public int getItemCount() {
        if(pets != null) {
            return pets.size();
        }
        return 0;
    }

    @Override
    public void onClick (View view) {
        Log.d("*****************", "click working");
    }
}

class CustomViewHolder extends RecyclerView.ViewHolder {
    protected TextView petName;
    protected ImageView petImage;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        this.petName = itemView.findViewById(R.id.petListName);
        this.petImage = itemView.findViewById(R.id.petInfoImage);
    }
}