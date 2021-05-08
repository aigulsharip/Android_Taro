package com.example.taroadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TaroWages extends AppCompatActivity {
    String [] wages = {"10000$", "20000$", "40000$", "80000$", "100000$","200000$","400000$", "800000$","1000000$","More than 1 000 000 per month "};

    Button startButton;
    TextView profText;
    Random random;
    ImageView image;
    boolean isStarted = true;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taro_wages);

        startButton = findViewById(R.id.startButton);
        image = findViewById(R.id.image);
        profText = findViewById(R.id.text);
        random = new Random();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //taro();
                manualStartStop();
            }
        });
    }

    // Task 2: Manual Stop and start function
    public void manualStartStop() {
        if (isStarted) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int profNum = random.nextInt(wages.length);
                            profText.setText(wages[profNum]);

                        }
                    });

                }
            }, 0, 10);
            startButton.setText("PAUSE");
        }
        else {
            timer.cancel();
            startButton.setText("START");
        }
        isStarted = !isStarted;
    }

    public void taro() {
        int num = random.nextInt(20);
        startButton.setEnabled(false);
        CountDownTimer timer = new CountDownTimer(num *100 + 1, 50) {
            @Override
            public void onTick(long millisUntilFinished) {
                int profNum = random.nextInt(wages.length);
                profText.setText(wages[profNum]);

            }

            @Override
            public void onFinish() {
                startButton.setEnabled(true);
            }
        };
        timer.start();
    }

    public void onClickStartMainMenu(View view) {
        Intent intent = new Intent(TaroWages.this, MainActivity.class);
        startActivity(intent);
    }
}