package com.demo.fragment_databinding_demo_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.demo.fragment_databinding_demo_app.databinding.FragmentContactBinding;
import com.demo.fragment_databinding_demo_app.databinding.FragmentProfileBinding;
import com.demo.fragment_databinding_demo_app.handlers.ContactClickHandler;
import com.demo.fragment_databinding_demo_app.handlers.ProfileClickHandler;
import com.demo.fragment_databinding_demo_app.models.Profile;

public class ContactFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentContactBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false);

        Profile profile = new Profile("John Doe", 25, "johndoe@gmail.com", "232-23-232");
        binding.setProfile(profile);
        binding.setClickHandler(new ContactClickHandler());


        return binding.getRoot();

    }
}