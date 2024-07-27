package com.example.germanteachingapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView2;
    ImageView birdimage;
    Button redbtn, bluebtn, greenbtn, whitebtn, blackbtn, pinkbtn;

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
        textView2 = findViewById(R.id.textView2);
        birdimage = findViewById(R.id.birdimage);
        redbtn = findViewById(R.id.redbtn);
        blackbtn = findViewById(R.id.blackbtn);
        bluebtn = findViewById(R.id.bluebtn);
        pinkbtn = findViewById(R.id.pinkbtn);
        greenbtn = findViewById(R.id.greenbtn);
        whitebtn = findViewById(R.id.whitebtn);
        redbtn.setOnClickListener(this);
        blackbtn.setOnClickListener(this);
        bluebtn.setOnClickListener(this);
        pinkbtn.setOnClickListener(this);
        whitebtn.setOnClickListener(this);
        greenbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int clickedBtnId = v.getId();
        if (clickedBtnId == R.id.redbtn) {
            PlaySounds(R.raw.red);
        } else if (clickedBtnId == R.id.bluebtn) {
            PlaySounds(R.raw.blue);
        } else if (clickedBtnId == R.id.blackbtn) {
            PlaySounds(R.raw.black);
        } else if (clickedBtnId == R.id.pinkbtn) {
            PlaySounds(R.raw.pink);
        } else if (clickedBtnId == R.id.greenbtn) {
            PlaySounds(R.raw.green);
        } else if (clickedBtnId == R.id.whitebtn) {
            PlaySounds(R.raw.white);
        }

    }

    public void PlaySounds(int Id) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, Id);
        mediaPlayer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_one,menu);
        return true;
    }
}