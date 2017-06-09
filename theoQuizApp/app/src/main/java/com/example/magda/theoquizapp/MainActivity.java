package com.example.magda.theoquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGr1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGr1.clearCheck();
        RadioGroup radioGr2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGr2.clearCheck();

    }

    @Override
    protected void onResume() {
        RadioGroup radioGr1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGr1.clearCheck();
        RadioGroup radioGr2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGr2.clearCheck();
        super.onResume();
    }

    public void countPoints(View view) {
        //What is the player Name
        EditText userName_view = (EditText) findViewById(R.id.playerName);
        //Create question 1 object
        RadioButton radiobutton1 = (RadioButton) findViewById(R.id.question1_good);
        //Create question 2 objects
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.question2_good1);
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.question2_good2);
        //Create question 3 object
        EditText answerBox = (EditText) findViewById(R.id.question3_good);
        //Create question 4 object
        RadioButton radiobutton2 = (RadioButton) findViewById(R.id.question4_good);
        /**
         * @param userName for the game
         */
        String userName = userName_view.getText().toString();

        //Check answers
        boolean a1 = radiobutton1.isChecked();
        boolean a21 = checkbox1.isChecked();
        boolean a22 = checkbox2.isChecked();
        String a3 = answerBox.getText().toString().toLowerCase();
        boolean a4 = radiobutton2.isChecked();
        //Log.v("MainActivity.java", "Sum of points is " + pointSum(a1, a21, a22, a3, a4));
        int numberOfPoints = pointSum(a1, a21, a22, a3, a4);
        showViews(userName, numberOfPoints);
        Toast.makeText(this, "Scroll down to see your result!", Toast.LENGTH_SHORT).show();

    }

    private int pointSum(boolean a1, boolean a21, boolean a22, String a3, boolean a4) {
        int points = 0;

        if (a1) {
            points += 1;
        }

        if (a21 && a22) {
            points += 1;
        }

        if (a3.equals("duda")) {
            points += 1;
        }

        if (a4) {
            points += 1;
        }

        return points;
    }

    private void showViews(String name, int points) {
        TextView finalText = (TextView) findViewById(R.id.finalTextView);
        finalText.setVisibility(View.VISIBLE);
        finalText.setText(name + getText(R.string.final_part1)+ " " + points + " " + getText(R.string.final_part2));
        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        rating.setVisibility(View.VISIBLE);
        rating.setRating(points);
        rating.setNumStars(4);
    }

}