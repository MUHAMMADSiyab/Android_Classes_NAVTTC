package com.demo.fragment_databinding_demo_app.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.demo.fragment_databinding_demo_app.ContactFragment;
import com.demo.fragment_databinding_demo_app.ProfileFragment;

public class ProfileFragmentStateAdapter extends FragmentStateAdapter {

    public ProfileFragmentStateAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? new ProfileFragment() : new ContactFragment();
    }

    public int getItemCount() {
        return 2;
    }
}
