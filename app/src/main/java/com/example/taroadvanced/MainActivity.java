package com.example.taroadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStartProf(View view) {
        Intent intent = new Intent(MainActivity.this, TaroProfession.class);
        startActivity(intent);
    }

    public void onClickStartPersonalLife(View view) {
        Intent intent = new Intent(MainActivity.this, TaroPersonalLife.class);
        startActivity(intent);
    }
    public void onClickStartWages(View view) {
        Intent intent = new Intent(MainActivity.this, TaroWages.class);
        startActivity(intent);
    }
}