package com.ashleymccallum.thebarkinglot.SurveyViewPager;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.ashleymccallum.thebarkinglot.R;

public class SurveyViewPagerAdapter extends FragmentStateAdapter implements ViewPager2.PageTransformer {

    public SurveyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return ImageFragment.newInstance(R.drawable.cat_young, R.string.kitten_img_desc);
            case 1: return ImageFragment.newInstance(R.drawable.dog_adult, R.string.dog_img_desc);
            case 2: return ImageFragment.newInstance(R.drawable.cat_elderly, R.string.elderly_cat_img_desc);
            case 3: return ImageFragment.newInstance(R.drawable.dog_young, R.string.puppy_img_desc);
            case 4: return ImageFragment.newInstance(R.drawable.misc_pets, R.string.misc_pet_img_desc);
            case 5: return ImageFragment.newInstance(R.drawable.dog_elderly, R.string.elderly_dog_img_desc);
            case 6: return ImageFragment.newInstance(R.drawable.cat_adult, R.string.cat_img_desc);
            case 7: return ImageFragment.newInstance(R.drawable.cat_young, R.string.kitten_img_desc);
            default: return ImageFragment.newInstance(R.drawable.cat_young, R.string.kitten_img_desc);
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {

        //load animation preference and add animation
        Animation animation = (Animation) AnimationUtils.loadAnimation(page.getContext(), R.anim.slideshow_animation);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(page.getContext());
        int animToggle = Integer.parseInt(sharedPreferences.getString("animationsMenu", "1"));

        //if 1 animations are on, if 0 animations are off
        if(animToggle == 1) {
            page.setAnimation(animation);
        }

    }
}
