package com.example.android.courtcounter;

import android.content.res.Configuration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int scoreTwo = 0;
    int ResetButton = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);

    }

    /**
     * Displays the given score for Team A.
     */


    public void displayForTeamA(int score) {

        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the given score for Team A by 3.
     */
    public void plusThreeForA(View view) {
        score = score + 3;
        displayForTeamA(score);
    }

    /**
     * Increase the given score for Team A by 2.
     */
    public void plusTwoForA(View view) {
        score = score + 2;
        displayForTeamA(score);
    }

    /**
     * Increase the given score for Team A  by 1.
     */
    public void plusOneForA(View view) {
        score = score + 1;
        displayForTeamA(score);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int scoreTwo) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTwo));
    }

    /**
     * Increase the given score for Team B  by 3.
     */
    public void plusThreeForB(View view) {
        scoreTwo = scoreTwo + 3;
        displayForTeamB(scoreTwo);
    }

    /**
     * Increase the given score for Team B  by 2.
     */
    public void plusTwoForB(View view) {
        scoreTwo = scoreTwo + 2;
        displayForTeamB(scoreTwo);
    }

    /**
     * Increase the given score for Team B  by 1.
     */
    public void plusOneForB(View view) {
        scoreTwo = scoreTwo + 1;
        displayForTeamB(scoreTwo);
    }


    public void ResetScore(View view) {
        scoreTwo = ResetButton;
        score = ResetButton;
        displayForTeamB(scoreTwo);
        displayForTeamA(score);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt("TeamAScore", score);
        savedInstanceState.putInt("TeamBScore", scoreTwo);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        score = savedInstanceState.getInt("TeamAScore");
        scoreTwo = savedInstanceState.getInt("TeamBScore");
        displayForTeamB(scoreTwo);
        displayForTeamA(score);

    }
}











