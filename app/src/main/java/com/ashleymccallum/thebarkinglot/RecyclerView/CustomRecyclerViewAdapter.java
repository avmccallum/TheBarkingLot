package com.ashleymccallum.thebarkinglot.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
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
import com.google.android.material.snackbar.Snackbar;

import java.net.URI;
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
        holder.petImage.setContentDescription(pet.getPetImageDesc());
        holder.petDesc.setText(pet.getDescription());
        holder.petListButton.setText(pet.getPetButtonName());
        holder.petListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(pet.getPetLink()));
                try {
                    holder.petListButton.getContext().startActivity(i);
                } catch (ActivityNotFoundException e) {
                    //TODO - make snackbar functional
//                    Snackbar.make(getContext().getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
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