package com.example.a374anroidsafetyapp;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.lifecycle.MutableLiveData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordStrengthCalculator implements TextWatcher {

    final static MutableLiveData<String> strengthLevel = new MutableLiveData<>();
    final static MutableLiveData<Integer> strengthColor = new MutableLiveData<>();

    public static MutableLiveData<Integer> lowerCase = new MutableLiveData();
    public static MutableLiveData<Integer> upperCase = new MutableLiveData<>();
    public static MutableLiveData<Integer> digit = new MutableLiveData<>();
    public static MutableLiveData<Integer> specialChar = new MutableLiveData<>();


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s != null) {
            if (hasLowerCase(s)) {
                lowerCase.setValue(1);
            } else {
                lowerCase.setValue(0);
            }

            if (hasUpperCase(s)) {
                upperCase.setValue(1);
            } else {
                upperCase.setValue(0);
            }

            if (hasDigit(s)) {
                digit.setValue(1);
            } else {
                digit.setValue(0);
            }

            if (hasSpecialChar(s)) {
                specialChar.setValue(1);
            } else {
                specialChar.setValue(0);
            }
            calculateStrength(s);
        }
    }

    public void calculateStrength(CharSequence password) {
        if (password.length() > 0 && password.length() < 8) {   // Password too short -> weak
            strengthColor.setValue(R.color.weak);
            strengthLevel.setValue("WEAK");
        } else if (password.length() > 7 && password.length() < 11){
            if (lowerCase.getValue() == 1 || upperCase.getValue() == 1 || digit.getValue() == 1 || specialChar.getValue() == 1) {   // Password okay in length, has one of each char type
                strengthColor.setValue(R.color.medium);
                strengthLevel.setValue("MEDIUM");
            }
        } else if (password.length() > 10 && password.length() < 17) {  // Password good length, good char -> strong
            if (lowerCase.getValue() == 1 || upperCase.getValue() == 1 || digit.getValue() == 1 || specialChar.getValue() == 1) {
                if (lowerCase.getValue() == 1 && upperCase.getValue() == 1) {
                    strengthColor.setValue(R.color.strong);
                    strengthLevel.setValue("STRONG");
                }
            }
        } else if (password.length() > 16) {
            if (lowerCase.getValue() == 1 && upperCase.getValue() == 1 && digit.getValue() == 1 && specialChar.getValue() == 1) {
                strengthColor.setValue(R.color.bulletproof);
                strengthLevel.setValue("VERY STRONG");
            }
        }
    }

    private boolean hasLowerCase(CharSequence cs) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher hasLowerCase = pattern.matcher(cs);
        return hasLowerCase.find();
    }

    private boolean hasUpperCase(CharSequence cs) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher hasUpperCase = pattern.matcher(cs);
        return hasUpperCase.find();
    }

    private boolean hasDigit(CharSequence cs) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher hasDigit = pattern.matcher(cs);
        return hasDigit.find();
    }

    private boolean hasSpecialChar(CharSequence cs) {
        Pattern pattern = Pattern.compile("[!@#$%^&*()_=+{}/.<>|\\[\\]~-]");
        Matcher hasSpecialChar = pattern.matcher(cs);
        return hasSpecialChar.find();
    }

}
