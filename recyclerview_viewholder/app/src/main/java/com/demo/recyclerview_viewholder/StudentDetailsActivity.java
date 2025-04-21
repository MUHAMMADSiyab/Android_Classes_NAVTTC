package com.demo.recyclerview_viewholder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.student_details_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView studentNameView = findViewById(R.id.studentNameView);
        TextView studentRollNumberView = findViewById(R.id.studentRollNumberView);
        Button backBtn = findViewById(R.id.backbtn);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int rollNumber = intent.getIntExtra("rollNumber",-1);

        studentNameView.setText(name);
        studentRollNumberView.setText("Roll Number: " + rollNumber);

        backBtn.setOnClickListener(v -> {
            finish();
        });

    }
}