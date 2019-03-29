package com.example.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int playerOne = 1;

    int[] stateOfGame = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    boolean continueGame = true;

    int[][] winningStates = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dropInView(View view){

        ImageView counter = (ImageView) view;

        if(stateOfGame[Integer.parseInt(counter.getTag().toString())-1] == -1 && continueGame) {
            stateOfGame[Integer.parseInt(counter.getTag().toString())-1] = playerOne;

            if (playerOne == 1) {
                counter.setTranslationY(-1000f);
            } else {
                counter.setTranslationX(-1000f);
            }
            if (playerOne == 1) {
                counter.setImageResource(R.drawable.newcross);
                playerOne = 0;
            } else {
                counter.setImageResource(R.drawable.newcircle);
                playerOne = 1;
            }
            if (playerOne == 1) {
                counter.animate().translationXBy(1000f).rotation(3600).setDuration(300);
            } else {
                counter.animate().translationYBy(1000f).rotation(3600).setDuration(300);
            }
        }
        for(int[] win : winningStates) {
            if (stateOfGame[win[0]] == stateOfGame[win[1]] &&
                    stateOfGame[win[1]] == stateOfGame[win[2]] && stateOfGame[win[0]] != -1) {
                TextView won = (TextView) findViewById(R.id.textView);

                if (playerOne == 1) {

                    won.setText(R.string.circle);

                } else {
                    won.setText(R.string.cross);
                }
                continueGame = false;

                RelativeLayout visibility = (RelativeLayout) findViewById(R.id.relativelayout);

                visibility.setVisibility(View.VISIBLE);
            }
        }
             if(continueGame) {
                   boolean gameOver = true;

                   for(int check : stateOfGame){
                       if(check == -1){
                           gameOver = false;
                       }
                   }
                   if(gameOver){
                       continueGame = false;
                       TextView won = (TextView) findViewById(R.id.textView);
                       won.setText(R.string.draw);
                       RelativeLayout visibility = (RelativeLayout) findViewById(R.id.relativelayout);

                       visibility.setVisibility(View.VISIBLE);
                   }
            }


    }
    public void playAgain(View view){

        RelativeLayout visibility = (RelativeLayout) findViewById(R.id.relativelayout);

        visibility.setVisibility(View.INVISIBLE);
        continueGame = true;
        playerOne = 1;
        for(int i=0;i<stateOfGame.length;i++){

            stateOfGame[i] = -1;
        }
        GridLayout gridlayout = (GridLayout)findViewById(R.id.gridlayout);
        for(int i=0;i< gridlayout.getChildCount();i++){

            ((ImageView)gridlayout.getChildAt(i)).setImageResource(0);
        }
    }
}
