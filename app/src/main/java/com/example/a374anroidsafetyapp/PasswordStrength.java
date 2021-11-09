package com.example.a374anroidsafetyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.w3c.dom.Text;

public class PasswordStrength extends AppCompatActivity {

    private int color = R.color.weak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_strength_activity);

        final PasswordStrengthCalculator PWSC = new PasswordStrengthCalculator();
        TextView passwordInput = (TextView) findViewById(R.id.password_input);
        passwordInput.addTextChangedListener(PWSC);

        TextView lowText = (TextView) findViewById(R.id.lowerCase_txt);
        TextView upText = (TextView) findViewById(R.id.upperCase_txt);
        TextView digText = (TextView) findViewById(R.id.digit_txt);
        TextView specialText = (TextView) findViewById(R.id.specialChar_txt);

        ImageView lowImg = (ImageView) findViewById(R.id.lowerCase_img);
        ImageView upImg = (ImageView) findViewById(R.id.upperCase_img);
        ImageView digImg = (ImageView) findViewById(R.id.digit_img);
        ImageView specialImg = (ImageView) findViewById(R.id.specialChar_img);


        final Observer<String> strengthLevelObserver = new Observer<String>() {
            @Override
            public void onChanged(String strengthLevel) {
                displayStrengthLevel(strengthLevel);
            }
        };

        final Observer<Integer> strengthColorObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer strengthColor) {
                color = strengthColor;
            }
        };

        final Observer<Integer> lowerCaseObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                updateRequirements(integer, lowImg, lowText);
            }
        };

        final Observer<Integer> upperCaseObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                updateRequirements(integer, upImg, upText);

            }
        };

        final Observer<Integer> digitObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                updateRequirements(integer, digImg, digText);

            }
        };

        final Observer<Integer> specialCharObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                updateRequirements(integer, specialImg, specialText);

            }
        };

        PasswordStrengthCalculator.strengthLevel.observe(this, strengthLevelObserver);
        PasswordStrengthCalculator.strengthColor.observe(this, strengthColorObserver);
        PasswordStrengthCalculator.lowerCase.observe(this, lowerCaseObserver);
        PasswordStrengthCalculator.upperCase.observe(this, upperCaseObserver);
        PasswordStrengthCalculator.digit.observe(this, digitObserver);
        PasswordStrengthCalculator.specialChar.observe(this, specialCharObserver);


    }

    private void displayStrengthLevel(String strengthLevel) {
        TextView strengthText = (TextView) findViewById(R.id.strength_level_txt);
        View strengthIndicator = (View) findViewById(R.id.strength_level_indicator);
        Button goButton = (Button) findViewById(R.id.gobutton);

        if (goButton.isEnabled()) {
            strengthLevel.contains("VERY STRONG");
        }

        strengthText.setText(strengthLevel);
        strengthText.setTextColor(ContextCompat.getColor(this, color));
        strengthIndicator.setBackgroundColor(ContextCompat.getColor(this, color));
    }

    private void updateRequirements(Integer val, ImageView img, TextView text) {
        if (val == 1) {
            img.setColorFilter(ContextCompat.getColor(this, R.color.bulletproof));
            text.setTextColor(ContextCompat.getColor(this, R.color.bulletproof));
        } else {
            img.setColorFilter(ContextCompat.getColor(this, R.color.darkGray));
            text.setTextColor(ContextCompat.getColor(this, R.color.darkGray));
        }
    }
}
