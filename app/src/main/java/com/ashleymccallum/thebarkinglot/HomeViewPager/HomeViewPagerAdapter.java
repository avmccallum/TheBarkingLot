package com.ashleymccallum.thebarkinglot.HomeViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ashleymccallum.thebarkinglot.R;

public class HomeViewPagerAdapter extends FragmentStateAdapter {

    public HomeViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return HomeInfoFragment.newInstance(R.string.foster_subtitle, R.string.foster_message, R.string.foster_button, R.string.foster_link);
            case 1: return HomeInfoFragment.newInstance(R.string.adopt_subtitle, R.string.adopt_message, R.string.adopt_button, R.string.adopt_link);
            case 2: return HomeInfoFragment.newInstance(R.string.donation_title, R.string.donation_message, R.string.donate_button, R.string.donate_link);
            case 3: return HomeInfoFragment.newInstance(R.string.event_title, R.string.event_message, R.string.event_button, R.string.event_link);
            case 4: return HomeInfoFragment.newInstance(R.string.invite_title, R.string.invite_message, R.string.invite_button, R.string.invite_link);
            default: return HomeInfoFragment.newInstance(R.string.foster_subtitle, R.string.foster_message, R.string.foster_button, R.string.foster_link);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }


}
