package com.example.practica1individualeventos;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PantallaMain extends AppCompatActivity {

    private TextView tvGreeting;
    private Button btnChangeName, btnChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallamain);

        tvGreeting = findViewById(R.id.tvGreeting);
        btnChangeName = findViewById(R.id.btnChangeName);
        btnChangeColor = findViewById(R.id.btnChangeColor);

        // Mostrar saludo según la hora del día
        setGreetingMessage();

        btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaMain.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaMain.this, ColorActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setGreetingMessage() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String greeting;

        if (hour >= 6 && hour < 12) {
            greeting = "Good Morning!";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Good Afternoon!";
        } else {
            greeting = "Good Evening!";
        }

        tvGreeting.setText(greeting);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Cargar el nombre guardado
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String userName = sharedPreferences.getString("userName", "");
        if (!userName.isEmpty()) {
            tvGreeting.setText(tvGreeting.getText() + " " + userName);
        }

        // Cambiar el color de fondo
        int backgroundColor = sharedPreferences.getInt("backgroundColor", -1);
        if (backgroundColor != -1) {
            findViewById(R.id.layout_main).setBackgroundColor(backgroundColor);
        }
    }
}