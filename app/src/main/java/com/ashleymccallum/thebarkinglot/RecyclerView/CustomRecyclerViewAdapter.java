package com.ashleymccallum.thebarkinglot.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashleymccallum.thebarkinglot.R;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
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
        holder.petDesc.setText(pet.getDescription());
        holder.petListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO - add button intent
            }
        });
    }

    @Override
    public int getItemCount() {
        if(pets != null) {
            return pets.size();
        }
        return 0;
    }
}

class CustomViewHolder extends RecyclerView.ViewHolder {
    protected TextView petName;
    protected ImageView petImage;
    protected TextView petDesc;
    protected Button petListButton;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        this.petName = itemView.findViewById(R.id.petListName);
        this.petImage = itemView.findViewById(R.id.petInfoImage);
        this.petDesc = itemView.findViewById(R.id.petListDesc);
        this.petListButton = itemView.findViewById(R.id.petListButton);
    }
}