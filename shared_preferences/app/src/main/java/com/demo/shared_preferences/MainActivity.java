package com.demo.shared_preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    TextView editName;
    TextView counterText;

    private int count;

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

        editName = findViewById(R.id.editName);
        counterText = findViewById(R.id.counterText);

        prefs = getSharedPreferences("MyCustomPrefs", MODE_PRIVATE);

        count = prefs.getInt("count", 0);

        editName.setText(prefs.getString("username", ""));
        counterText.setText(String.valueOf(count));

    }

    public void saveData(View view) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", editName.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void showData(View view) {
        String username = prefs.getString("username", "No Name");
        Toast.makeText(this, "Name: " + username, Toast.LENGTH_SHORT).show();
    }

    public void removeData(View view) {
        prefs.edit().remove("username").apply();
        Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show();

    }

    public void clearAllData(View view) {
        prefs.edit().clear().apply();
        Toast.makeText(this, "Cleared All", Toast.LENGTH_SHORT).show();

    }

    public void increment(View view) {
        count++;
        prefs.edit().putInt("count", count).apply();
        counterText.setText(String.valueOf(prefs.getInt("count", 0)));
    }


}