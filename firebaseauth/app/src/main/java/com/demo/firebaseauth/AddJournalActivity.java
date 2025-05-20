package com.demo.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.demo.firebaseauth.models.Journal;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

public class AddJournalActivity extends AppCompatActivity {

    EditText titleField, contentField;
    Button addJournalBtn;
    FirebaseAuth auth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        auth = FirebaseAuth.getInstance();


        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_journal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addJournal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = FirebaseFirestore.getInstance();

        titleField = findViewById(R.id.titleField);
        contentField = findViewById(R.id.contentField);
        addJournalBtn = findViewById(R.id.addJournalBtn);

        addJournalBtn.setOnClickListener(v -> {
            String title = titleField.getText().toString();
            String content = contentField.getText().toString();
            String userId = auth.getUid();
            Timestamp timestamp = new Timestamp(new Date());

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Title and content cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            Journal journal = new Journal(title, content, userId, timestamp);

           addJournal(journal);

        });
    }

    private void addJournal(Journal journal) {
        db.collection("journals")
                .add(journal)
                .addOnSuccessListener(doc -> {
                    Toast.makeText(this, "Journal added successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, JournalListActivity.class));
                    finish();
                });
    }
}