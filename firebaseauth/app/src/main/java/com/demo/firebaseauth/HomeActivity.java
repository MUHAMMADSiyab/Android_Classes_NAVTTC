package com.demo.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    TextView userInfo;
    Button logoutBtn, openAddJournalBtn, openViewJournalsBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        auth = FirebaseAuth.getInstance();

        auth.addAuthStateListener(authState -> {
            if (authState.getCurrentUser() == null) {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }
        });

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userInfo = findViewById(R.id.userInfo);
        logoutBtn = findViewById(R.id.logoutBtn);
        openAddJournalBtn = findViewById(R.id.openAddJournalBtn);
        openViewJournalsBtn = findViewById(R.id.openViewJournalsBtn);

        FirebaseUser user = auth.getCurrentUser();

        openAddJournalBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, AddJournalActivity.class));
            finish();
        });

        openViewJournalsBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, JournalListActivity.class));
            finish();
        });



        if (user != null) {
            userInfo.setText("Email: " + user.getEmail());
        }


        logoutBtn.setOnClickListener(v -> {
            auth.signOut();

            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}