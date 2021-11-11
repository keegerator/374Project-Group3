package com.example.a374anroidsafetyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu  extends AppCompatActivity implements View.OnClickListener {
    private Button phishing,security,password,settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        phishing = (Button)findViewById(R.id.phishingButton);
        security = (Button)findViewById(R.id.securityButton);
        password = (Button)findViewById(R.id.passwordButton);
        settings = (Button)findViewById(R.id.settingsButton);

        phishing.setOnClickListener(this);
        security.setOnClickListener(this);
        password.setOnClickListener(this);
        settings.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == phishing.getId()){
            startActivity(new Intent(this,Phishing.class));
        }
        else if (id == security.getId()){
            startActivity(new Intent(this,securityQuiz.class));
        }
        else if (id == password.getId()){
            startActivity(new Intent(this,PasswordStrength.class));
        }
        else
            startActivity(new Intent(this,recommendedSettings.class));


    }
}
