package com.demo.fragmentsdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.demo.fragmentsdemo.databinding.FragmentFirstBinding;
import com.demo.fragmentsdemo.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentSecondBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);
        binding.setMessage2("Hello World from Second Fragment!!!");

        return binding.getRoot();
    }
}