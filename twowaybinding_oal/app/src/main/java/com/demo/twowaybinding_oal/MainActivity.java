package com.demo.twowaybinding_oal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.demo.twowaybinding_oal.databinding.ActivityMainBinding;
import com.demo.twowaybinding_oal.models.User;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        user = new User();
        user.setName("Abdul Basit Raza");
        user.setEmail("abdulbasitraza@yahoo.com");
        binding.setUser(user);

        binding.loginBtn.setOnClickListener(v -> {
            Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show();


        });

    }
}