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

public class TaroProfession extends AppCompatActivity {
    String [] profs = {"Genetics", "Doctor", "Architect", "Life Saver", "Firefighter","Cosmonaut","Detective", "Footballer","Politician","Economist"};
    //Task 1: Inserting image of profession
    int[] myImageList = new int[]{R.drawable.genetics, R.drawable.doctor, R.drawable.architect,R.drawable.lifesaver,R.drawable.fireman,R.drawable.cosmonaut,
            R.drawable.detective,R.drawable.footballer,R.drawable.politician,R.drawable.economist};

    Button startButton;
    TextView profText;
    Random random;
    ImageView image;
    boolean isStarted = true;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taro_profession);

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
                            int profNum = random.nextInt(profs.length);
                            profText.setText(profs[profNum]);
                            image.setImageResource(myImageList[profNum]);
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
                int profNum = random.nextInt(profs.length);
                profText.setText(profs[profNum]);
                //Task 1: Inserting image of profession
                //image.setImageDrawable(getResources().getDrawable(R.drawable.genetics));
                image.setImageResource(myImageList[profNum]);
            }

            @Override
            public void onFinish() {
                startButton.setEnabled(true);
            }
        };
        timer.start();
    }

    public void onClickStartMainMenu(View view) {
        Intent intent = new Intent(TaroProfession.this, MainActivity.class);
        startActivity(intent);
    }
}