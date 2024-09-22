package com.example.practica1individualeventos;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnSaveName;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etName = findViewById(R.id.etName);
        btnSaveName = findViewById(R.id.btnSaveName);

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        btnSaveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userName", name);
                editor.apply();

                Intent intent = new Intent(RegistroActivity.this, PantallaMain.class);
                startActivity(intent);
                finish();
            }
        });
    }
}