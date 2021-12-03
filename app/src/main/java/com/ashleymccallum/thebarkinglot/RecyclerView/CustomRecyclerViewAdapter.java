package com.ashleymccallum.thebarkinglot.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
            holder.petHours.setText(pet.getPetDesc());
            holder.petActivity.setVisibility(View.GONE);
            holder.petExperience.setVisibility(View.GONE);
            holder.petEnclosure.setVisibility(View.GONE);
            holder.petOutdoor.setVisibility(View.GONE);
            holder.petCompanion.setVisibility(View.GONE);
            holder.petGrooming.setVisibility(View.GONE);
        } else {
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



//        holder.petListButton.setText(pet.getPetButton());
//        holder.petListButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(pet.getPetLink()));
//                try {
//                    holder.petListButton.getContext().startActivity(i);
//                } catch (ActivityNotFoundException e) {
//                    //TODO - make snackbar functional
////                    Snackbar.make(getContext().getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
//                }
//            }
//        });
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
//    protected Button petListButton;

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
//        this.petListButton = itemView.findViewById(R.id.petListButton);
    }
}