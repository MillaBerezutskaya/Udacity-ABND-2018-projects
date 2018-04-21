package com.example.android.udacityfunquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    /**
     * this is a 6 consisting questions application quiz made to test basics of xml
     * int is a global variable that is available during the whole code
     * here we initialize all types of questions
     */
    int score = 0;
    RadioButton question1;
    RadioButton question2;
    CheckBox question3_checkBox1;
    CheckBox question3_checkBox2;
    CheckBox question3_checkBox3;
    CheckBox question3_checkBox4;
    EditText question4;
    RadioButton question5;
    RadioButton question6;

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question3_checkBox1 = findViewById(R.id.question3_checkBox1);
        question3_checkBox2 = findViewById(R.id.question3_checkBox2);
        question3_checkBox3 = findViewById(R.id.question3_checkBox3);
        question3_checkBox4 = findViewById(R.id.question3_checkBox4);
        question4 = findViewById(R.id.question_EditText1);
        radioGroup1 = findViewById(R.id.question_radioGroup1);
        radioGroup2 = findViewById(R.id.question_radioGroup2);
        radioGroup3 = findViewById(R.id.question_radioGroup3);
        radioGroup4 = findViewById(R.id.question_radioGroup4);
        question1 = findViewById(R.id.question_radioGroup1_radioButton3);
        question2 = findViewById(R.id.question_radioGroup2_radioButton2);
        question5 = findViewById(R.id.question_radioGroup3_radioButton1);
        question6 = findViewById(R.id.question_radioGroup4_radioButton2);

    }


    /**
     * In this method clearCheck clears the selection and setChecked changes the checked state of the view
     */

    public void resetAnswers() {


        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();

        question3_checkBox1.setChecked(false);
        question3_checkBox2.setChecked(false);
        question3_checkBox3.setChecked(false);
        question3_checkBox4.setChecked(false);
        question4.setText("");

    }

    /**
     *  This method calculates the score based on the right answers given
     **/

    public int calculateScore(int score) {


        boolean firstQuestion =
                question1.isChecked();
        if (firstQuestion) score += 1;


        boolean secondQuestion =
                question2.isChecked();
        if (secondQuestion) {
            score += 1;
        }

        boolean fifthQuestion =
                question5.isChecked();
        if (fifthQuestion) {
            score += 1;
        }

        boolean sixthQuestion =
                question6.isChecked();
        if (sixthQuestion) {
            score += 1;
        }

        if ((question3_checkBox2.isChecked() && question3_checkBox3.isChecked()) && !(question3_checkBox1.isChecked() || question3_checkBox4.isChecked())) {
            score += 1;
        }

        String fourthQuestion = question4.getText().toString();
        if (fourthQuestion.contains("Xml"))
            score += 1;
        else if (fourthQuestion.contains("xml") || fourthQuestion.contains("XML"))
            score += 1;
        return (score);

    }

    /**
     * After Check button is pressed the application shows the final Score using Toast
     **/

    public void DisplayResults(View view) {
        int finalScore = calculateScore(score);
        String finalScoreMessage = "You answered correctly " + finalScore + " questions out of 6!";
        Toast.makeText(this, finalScoreMessage, Toast.LENGTH_LONG).show();
        resetAnswers();
    }
}

