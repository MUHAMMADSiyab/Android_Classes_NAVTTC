package com.demo.databases;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.demo.databases.helpers.DatabaseHelper;
import com.demo.databases.models.User;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DatabaseHelper dbHelper = new DatabaseHelper(this);

//        dbHelper.updateUser(1, "name", "Abdul Gaffar");
        dbHelper.deleteUser(1);

//        dbHelper.insertUser("Abdul Basit Raza", "abdulbasit@gmail.com", "P@ssw0rd");
//        dbHelper.insertUser("Iqra", "iqra@gmail.com", "P@ssw0rd@123");

        List<User> users = dbHelper.getUsers();

        for(User user: users) {
//            Log.d("User Record: ", user.getName());
        }

        Paper.init(this);

        Paper.book("settings").write("volume", 60);
        Paper.book("user_preferences").write("resolution", "720p");


        int volume = Paper.book("settings").read("volume");
        String res = Paper.book("user_preferences").read("resolution");

        Log.d("PaperDB Data" , String.valueOf(volume));
        Log.d("PaperDB Data" , res);


    }
}