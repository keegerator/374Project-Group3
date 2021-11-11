package com.example.a374anroidsafetyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import nu.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class passwordStrength extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_strength_activity);


        EditText passwordInputEditText = (EditText)findViewById(R.id.passwordInputEditText);
        PasswordStrengthMeter meter = findViewById(R.id.passwordInputMeter);
        meter.setEditText(passwordInputEditText);


    }
    public void back(View v){
        finish();
    }
}
