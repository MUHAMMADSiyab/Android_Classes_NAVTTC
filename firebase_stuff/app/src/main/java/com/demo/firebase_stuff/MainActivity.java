package com.demo.firebase_stuff;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.demo.firebase_stuff.adapters.UsersListAdapter;
import com.demo.firebase_stuff.models.User;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;
    ArrayList<User> users = new ArrayList<>();
    UsersListAdapter adapter;

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

        db = FirebaseFirestore.getInstance();

        ListView usersListView = findViewById(R.id.usersListView);

        adapter = new UsersListAdapter(this, users);

        usersListView.setAdapter(adapter);

//        db.collection("users")
//                .document("ufeHZ964rz5up23H0zeM")
//                        .update("name", "John Wick");

//        db.collection("users")
//                .document("ufeHZ964rz5up23H0zeM")
//                        .delete();

        getUsers();


    }

    public void saveUserInfo(View view) {
        EditText editName = findViewById(R.id.editName);
        EditText editEmail = findViewById(R.id.editEmail);

        String name = editName.getText().toString();
        String email = editEmail.getText().toString();

        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Cannot create empty user", Toast.LENGTH_SHORT).show();
            return;
        }


        view.setEnabled(false);


        User user = new User(name, email);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(v -> {

                    users.add(new User(name, email));

                    adapter.notifyDataSetChanged();

                    // Clear fields
                    editName.setText("");
                    editEmail.setText("");

                    view.setEnabled(true);

                    Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show();

                })
                .addOnFailureListener(error -> {
                    Toast.makeText(this, "Failed to save data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                });

    }

    private void getUsers() {
        TextView loadingText = findViewById(R.id.loadingText);
        loadingText.setVisibility(View.VISIBLE);

        db.collection("users")
//                .whereEqualTo("name", "Abdul Basit")
                .orderBy("name", Query.Direction.DESCENDING)
                .limit(10)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                   for (DocumentSnapshot doc: queryDocumentSnapshots) {
                       User user = doc.toObject(User.class);

                       if (user != null) {
                           users.add(user);
                       }
                   }

                   adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(error -> {
                    Toast.makeText(this, "Failed to get data: " + error.getMessage() , Toast.LENGTH_SHORT).show();
                })
                .addOnCompleteListener(v -> {
                    loadingText.setVisibility(View.GONE);
                });
    }

}