package com.example.a374anroidsafetyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class securityQuiz extends AppCompatActivity {
    generator gc = new generator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.security_quiz_activity);

        initialize();
    }

    private void initialize() {
        gc.generate();
        int correct = gc.getCorrect();
        int total = gc.getTotal();

        String question = gc.getQuestions(gc.index);
        String answer1 = gc.getAnswer1(gc.index);
        String answer2 = gc.getAnswer2(gc.index);
        String answer3 = gc.getAnswer3(gc.index);
        String answer4 = gc.getAnswer4(gc.index);


        TextView textQuestion =(TextView)findViewById(R.id.textQuestion);
        textQuestion.setText(question);

        RadioButton button1 =(RadioButton)findViewById(R.id.optionOne);
        button1.setText(answer1);

        RadioButton button2 =(RadioButton)findViewById(R.id.optionTwo);
        button2.setText(answer2);

        RadioButton button3=(RadioButton)findViewById(R.id.optionThree);
        button3.setText(answer3);

        RadioButton button4=(RadioButton)findViewById(R.id.optionFour);
        button4.setText(answer4);

        TextView trackerText = (TextView)findViewById(R.id.scoreTracker);
        trackerText.setText(correct+"/"+total);

        Button submitButton =(Button)findViewById(R.id.submitButton);
        Button nextButton =(Button)findViewById(R.id.nextButton);

        submitButton.setEnabled(true);
        nextButton.setEnabled(false);

    }
    public void next(View v){
        gc.generate();
        int correct = gc.getCorrect();
        int total = gc.getTotal();

        String question = gc.getQuestions(gc.index);
        String answer1 = gc.getAnswer1(gc.index);
        String answer2 = gc.getAnswer2(gc.index);
        String answer3 = gc.getAnswer3(gc.index);
        String answer4 = gc.getAnswer4(gc.index);
        TextView textQuestion =(TextView)findViewById(R.id.textQuestion);
        textQuestion.setText(question);

        RadioButton button1 =(RadioButton)findViewById(R.id.optionOne);
        button1.setText(answer1);

        RadioButton button2 =(RadioButton)findViewById(R.id.optionTwo);
        button2.setText(answer2);

        RadioButton button3=(RadioButton)findViewById(R.id.optionThree);
        button3.setText(answer3);

        RadioButton button4=(RadioButton)findViewById(R.id.optionFour);
        button4.setText(answer4);

        button1.setChecked(false);
        button2.setChecked(false);
        button3.setChecked(false);
        button4.setChecked(false);


        TextView trackerText = (TextView)findViewById(R.id.scoreTracker);
        trackerText.setText(correct+"/"+total);

        Button submitButton =(Button)findViewById(R.id.submitButton);
        Button nextButton =(Button)findViewById(R.id.nextButton);

        submitButton.setEnabled(true);
        nextButton.setEnabled(false);
        if (gc.index==4){
            submitButton.setEnabled(true);
            nextButton.setEnabled(false);
        }

    }
    public void submit(View v){
        int key = gc.getKey(gc.index);
        int userAnswer;
        RadioGroup answerRadio = (RadioGroup)findViewById(R.id.answerGroup);
        int id = answerRadio.getCheckedRadioButtonId();
        if(id==R.id.optionOne)
            userAnswer=0;
        else if(id==R.id.optionTwo)
            userAnswer=1;
        else if(id==R.id.optionThree)
            userAnswer=2;
        else
            userAnswer=3;

        if(userAnswer==key){
            gc.increaseCorrect();
        }
        if (answerRadio.getCheckedRadioButtonId() == -1)
        {
            userAnswer = -1;
        }
        gc.increaseTotal();

        int correct = gc.getCorrect();
        int total = gc.getTotal();
        TextView trackerText = (TextView)findViewById(R.id.scoreTracker);
        trackerText.setText(correct+"/"+total);

        Button submitButton =(Button)findViewById(R.id.submitButton);
        Button nextButton =(Button)findViewById(R.id.nextButton);
        submitButton.setEnabled(false);
        nextButton.setEnabled(true);
        if (gc.index==4){
            submitButton.setEnabled(true);
            nextButton.setEnabled(false);
        }

    }

}
