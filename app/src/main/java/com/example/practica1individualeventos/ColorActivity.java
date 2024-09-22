package com.example.practica1individualeventos;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {

    private Button btnColorRed, btnColorGreen, btnColorBlue;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        btnColorRed = findViewById(R.id.btnColorRed);
        btnColorGreen = findViewById(R.id.btnColorGreen);
        btnColorBlue = findViewById(R.id.btnColorBlue);

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        btnColorRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveColorPreference(Color.RED);
            }
        });

        btnColorGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveColorPreference(Color.GREEN);
            }
        });

        btnColorBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveColorPreference(Color.BLUE);
            }
        });
    }

    private void saveColorPreference(int color) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("backgroundColor", color);
        editor.apply();

        Intent intent = new Intent(ColorActivity.this, PantallaMain.class);
        startActivity(intent);
        finish();
    }
}