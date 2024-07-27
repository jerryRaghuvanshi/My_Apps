package com.example.luckeynumberapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView textView, text2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        text2 = findViewById(R.id.text2);
        // Receiving data from main activity
        Intent i = getIntent();
        String username = i.getStringExtra("name");
        int random_num = GenerateRandomNumber();
        textView.setText("" + random_num);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username, random_num);
            }
        });
// Generating random number
    }

    public int GenerateRandomNumber() {
        Random random = new Random();
        int upper_limit = 1000;
        return random.nextInt(upper_limit);
    }

    public void shareData(String username, int random_num) {
        // implicit intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        // Additional info
        i.putExtra(Intent.EXTRA_SUBJECT, username + " got a Lucky number");
        i.putExtra(Intent.EXTRA_TEXT, "His Lucky Number is " + random_num);

        startActivity(Intent.createChooser(i, "chose a platform"));

    }
}