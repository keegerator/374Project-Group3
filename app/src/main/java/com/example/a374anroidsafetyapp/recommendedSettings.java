package com.example.a374anroidsafetyapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class recommendedSettings extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommended_settings_activity);


    }
    public void back(View v){
        finish();
    }
}

