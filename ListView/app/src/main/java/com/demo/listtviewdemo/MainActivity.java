package com.demo.listtviewdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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


        ListView usersListView = findViewById(R.id.usersListView);
        GridView usersGridView = findViewById(R.id.usersGridView);


        String[] users = { "John", "Brad", "Kim", "Tom", "Sara", "Smith", "Alice", "Kyle", "Abdul Basit" };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_list_view_item,
                R.id.customListItemView,
                users

        );

//        usersListView.setAdapter(adapter);

        usersGridView.setAdapter(adapter);

//        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
//
//                //
//                Toast.makeText(MainActivity.this, "Selected User: " + users[index], Toast.LENGTH_SHORT).show();
//            }
//        });

        usersGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                
                Toast.makeText(MainActivity.this, "Selected User: " + users[index], Toast.LENGTH_SHORT).show();
            }
        });

    }

}