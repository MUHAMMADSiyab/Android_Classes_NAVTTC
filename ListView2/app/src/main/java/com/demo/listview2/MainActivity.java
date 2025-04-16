package com.demo.listview2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.demo.listview2.adapters.StudentAdapter;
import com.demo.listview2.models.Student;

import java.util.ArrayList;

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


        ListView listView = findViewById(R.id.listView);
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Abdul Basit Raza", 1));
        students.add(new Student("Shafi Muhammad", 2));
        students.add(new Student("Bob", 3));
        students.add(new Student("John Doe", 4));
        students.add(new Student("Sara Smith", 5));
        students.add(new Student("Brad Traversy", 6));

        StudentAdapter adapter = new StudentAdapter(this, students);

        listView.setAdapter(adapter);

    }




}