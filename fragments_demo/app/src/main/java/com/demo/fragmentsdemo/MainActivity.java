package com.demo.fragmentsdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.demo.fragmentsdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private boolean showingFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        loadFragment(new FirstFragment());

        Button switchBtn = binding.switchBtn;
        switchBtn.setOnClickListener(v -> {

            if (this.showingFirst) {
                loadFragment(new SecondFragment());
            } else {
                loadFragment(new FirstFragment());
            }

            this.showingFirst = !this.showingFirst;

        });



    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }


    @Override
    protected  void onStart() {
        super.onStart();

        Log.d("MainLogs", "On Start is triggered!");
    }

    @Override
    protected  void onResume() {
        super.onResume();

        Log.d("MainLogs", "On Resume is triggered!");
    }

    @Override
    protected  void onStop() {
        super.onStop();

        Log.d("MainLogs", "On Stop is triggered!");
    }

    @Override
    protected  void onPause() {
        super.onPause();

        Log.d("MainLogs", "On Pause is triggered!");
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();

        Log.d("MainLogs", "On Destory is triggered!");
    }
}