package com.example.tictoetoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    String winnerStr;

    //player Representation
    // 1 - x
    // 0 - 0
    // 2 - null
    int activePlayer = 0;
    //
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {0, 4, 8}};

    @SuppressLint("SetTextI18n")
    public void Player_tap(View view) {
        TextView topTurnIndicator = findViewById(R.id.top_turn_indicator);
        TextView bottomTurnIndicator = findViewById(R.id.bottom_turn_indicator);
        if (!gameActive) {
            reset(view);
        }
        ImageView img = (ImageView) view;
        int TappedImage = Integer.parseInt(img.getTag().toString());
        if (gameState[TappedImage] == 2) {
            gameState[TappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.oo);
                activePlayer = 1;

                topTurnIndicator.setText("your Turn");
                bottomTurnIndicator.setText("");

            } else {
                img.setImageResource(R.drawable.xx);
                activePlayer = 0;
                topTurnIndicator.setText("");
                bottomTurnIndicator.setText("your Turn");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] winPosition : winPositions) {
            if (isGameFinished(gameState)){

                        winnerStr = " DRAW";
                        reset(view);
                goToSecondActivity();


            }
           else if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {

                 if (gameState[winPosition[0]] == 0) {

                             gameActive = false;
                             winnerStr = " 0 HAS WON";



                } else  {


                             gameActive = false;
                             winnerStr = " X HAS WON";





                }
                reset(view);
                goToSecondActivity();



            }
        }


    }


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

    }

    public void goToSecondActivity() {


        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("who", winnerStr);
        startActivity(intent);
    }

    public void reset(View view) {
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView10)).setImageResource(0);
    }
    public boolean isGameFinished(int[] gameState) {

        return gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2 && gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 && gameState[7] != 2 && gameState[8] != 2;// All elements are 0 or 1
    }

}