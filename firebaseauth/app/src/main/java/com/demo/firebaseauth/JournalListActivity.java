package com.demo.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.firebaseauth.adapters.JournalListAdapter;
import com.demo.firebaseauth.models.Journal;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class JournalListActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore db;
    RecyclerView recyclerView;
    ArrayList<Journal> journalList;
    JournalListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        auth = FirebaseAuth.getInstance();


        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_journal_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewJournalsView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        journalList = new ArrayList<>();

        adapter = new JournalListAdapter(journalList);
        recyclerView.setAdapter(adapter);

        loadJournals();
    }

    private void loadJournals() {
        db.collection("journals")
                .whereEqualTo("userId", auth.getUid())
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    journalList.clear();
                    for (DocumentSnapshot doc: queryDocumentSnapshots) {
                        Journal journal = doc.toObject(Journal.class);
                        journalList.add(journal);
                    }

                    adapter.notifyDataSetChanged();

                })
                .addOnFailureListener(error -> {
                    Log.d("Firestore Error: ", error.getMessage());
                });
    }
}