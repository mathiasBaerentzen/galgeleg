package com.example.myapplication.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.controlers.GameController;
import com.example.myapplication.models.Words;

import java.util.ArrayList;

public class ActivityGame extends AppCompatActivity {



    //variabels
    final int attemps = 10;
    Words Words = new Words();
    final ArrayList<String> wordList = Words.getWordList(1) ;
    // følgende variabler kunne godt blive lagt i en model kaldet GameOpsætning men da gameopsætning ikke blev implamenteret ordenligt blev det skrottet i final version for et mere stabilt build

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final GameController gameController = new GameController();
        int random = (int)(Math.random() * wordList.size());
        final String word = wordList.get(random);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //BTN
        Button btnRunTurn = (Button) findViewById(R.id.BTN_pickLetter);
        // TextView
        final TextView TXT_Attemps = (TextView) findViewById(R.id.TXT_attemps);
        final TextView TXT_word = (TextView) findViewById(R.id.TXT_word);
        final TextView TXT_usedLeter = (TextView) findViewById(R.id.TXT_usedLeter);
        // PlainText
        final TextView INP_pickLetter = (TextView) findViewById(R.id.INP_pickLetter);
        // label
        final TextView LB_usedLeter = (TextView) findViewById(R.id.LB_usedLetter);
        final TextView LB_pickLetterText = (TextView) findViewById(R.id.LB_pickLetterText);
        final TextView LB_usedLetter = (TextView) findViewById(R.id.LB_usedLetter);

        int counts = 0;
        for (int i = 0; i < word.length();i++){
            counts++;
            System.out.println(counts);
        }

        for (int J = 0;counts > J;J++){
            TXT_word.setText(TXT_word.getText() +"*");
        }
        TXT_Attemps.setText("Forsøg:"+attemps);
        btnRunTurn.setOnClickListener(new View.OnClickListener() {

            int i = attemps;
            @Override
            public void onClick(View view) {

                String leter = INP_pickLetter.getText().toString();
                String usedLeters = TXT_usedLeter.getText().toString();
                String headerWord = TXT_word.getText().toString();
                String gameCondition = gameController.runGame(word, leter, headerWord, i);
                if (usedLeters.contains(leter)) {
                    LB_usedLeter.setText("bogstavet er brugt");
                }
                LB_usedLeter.setText("brugte bogstaver");
                TXT_usedLeter.setText(TXT_usedLeter.getText() + " " + leter);

                if (gameCondition == "true") {
                    launchActivity(true, word, attemps - i);
                } if (gameCondition == "false") {
                    launchActivity(false, word, attemps - i);
                }
                    TXT_word.setText(gameCondition);
                    i--;
                    TXT_Attemps.setText("Forsøg:" + i);

            }
        });
    }

    private void launchActivity(boolean condition,String Word, int attemps) {
        // if condition is true the game is won if condition is false then game lost
        Intent intent = new Intent(this, ActivityEndGame.class);
        intent.putExtra("Condition", condition );
        intent.putExtra("Word", Word );
        intent.putExtra("Attemps", attemps );
        startActivity(intent);
    }


}
