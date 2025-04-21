package com.demo.recyclerview_viewholder;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.recyclerview_viewholder.adapters.StudentAdapter;
import com.demo.recyclerview_viewholder.models.Student;

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

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Abdul Basit", 1));
        students.add(new Student("Brad Traversy", 2));
        students.add(new Student("Mike", 3));
        students.add(new Student("Sara Smith", 4));
        students.add(new Student("Kyle", 5));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StudentAdapter adapter = new StudentAdapter(students, this);
        recyclerView.setAdapter(adapter);

    }
}