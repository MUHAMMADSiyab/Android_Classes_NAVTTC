package com.demo.fragment_databinding_demo_app.handlers;

import android.view.View;
import android.widget.Toast;

public class ContactClickHandler {
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Contact Button Clicked!!", Toast.LENGTH_SHORT).show();
    }
}
