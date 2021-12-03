package com.ashleymccallum.thebarkinglot.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashleymccallum.thebarkinglot.Pet;
import com.ashleymccallum.thebarkinglot.R;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private ArrayList<Pet> pets;

    public CustomRecyclerViewAdapter(ArrayList<Pet> pets) {
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
        Pet pet = pets.get(position);
        if(pet.getPetDesc() != null) {
            //if there is a description, set the
            holder.petDescription.setText(pet.getPetDesc());
            holder.scrollView.setVisibility(View.GONE);
        } else {
            holder.petDescription.setVisibility(View.GONE);
            holder.petHours.setText(pet.getPetHours());
            holder.petActivity.setText(pet.getPetActivity());
            holder.petExperience.setText(pet.getPetExperience());
            holder.petEnclosure.setText(pet.getPetEnclosure());
            holder.petOutdoor.setText(pet.getPetOutdoor());
            holder.petCompanion.setText(pet.getPetCompanion());
            holder.petGrooming.setText(pet.getPetGrooming());
        }
        holder.petName.setText(pet.getPetName());
        holder.petImage.setImageResource(pet.getPetImage());
        holder.petImage.setContentDescription(pet.getPetImgDesc());
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
    protected TextView petHours;
    protected TextView petActivity;
    protected TextView petExperience;
    protected TextView petEnclosure;
    protected TextView petOutdoor;
    protected TextView petCompanion;
    protected TextView petGrooming;
    protected TextView petDescription;
    protected ScrollView scrollView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        this.petName = itemView.findViewById(R.id.petListName);
        this.petImage = itemView.findViewById(R.id.petInfoImage);
        this.petHours = itemView.findViewById(R.id.petHours);
        this.petActivity = itemView.findViewById(R.id.petActivity);
        this.petExperience = itemView.findViewById(R.id.petExperience);
        this.petEnclosure = itemView.findViewById(R.id.petEnclosure);
        this.petOutdoor = itemView.findViewById(R.id.petOutdoor);
        this.petCompanion = itemView.findViewById(R.id.petCompanion);
        this.petGrooming = itemView.findViewById(R.id.petGrooming);
        this.petDescription = itemView.findViewById(R.id.petDescText);
        this.scrollView = itemView.findViewById(R.id.petInfoScroll);

    }
}