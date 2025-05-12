package com.demo.firebase_stuff;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.demo.firebase_stuff.adapters.UsersListAdapter;
import com.demo.firebase_stuff.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseRef;

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

        databaseRef = FirebaseDatabase.getInstance().getReference("users");

        ListView userListView = findViewById(R.id.usersListView);

        ArrayList<User> users = new ArrayList<>();

        UsersListAdapter adapter = new UsersListAdapter(this, users);
        userListView.setAdapter(adapter);




//        databaseRef.child("-OQ3K2ugDznPUdbLvX9b").child("name").setValue("Kamran Khan"); // update
//        databaseRef.child("-OQ3K2ugDznPUdbLvX9b").removeValue(); // delete

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();
                for (DataSnapshot userSnapshot: snapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);

                    if (user != null) {
                        users.add(user);
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Firebase Error: ", error.getMessage());

            }
        });

    }

    public void saveUserInfo(View view) {
        EditText editName = findViewById(R.id.editName);
        EditText editEmail = findViewById(R.id.editEmail);


        String userId = databaseRef.push().getKey();

        User user = new User(editName.getText().toString(), editEmail.getText().toString());

        databaseRef.child(userId).setValue(user)
                .addOnSuccessListener(v -> {
                    Toast.makeText(this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(error -> {
                    Toast.makeText(this, "Unable to add a user" + error.getMessage(), Toast.LENGTH_SHORT).show();
                });

    }
}