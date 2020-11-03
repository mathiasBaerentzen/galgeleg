package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.controlers.JsonController;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class ActivityEndGame extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_view);

        Button BTN_FrontView = (Button) findViewById(R.id.BTN_mainView);

        Intent intent = getIntent();

        boolean condition = intent.getBooleanExtra("Condition", false);
        String word = intent.getStringExtra("Word");
        int attemps = intent.getIntExtra("Attemps",0);
        TextView TXT_endGameText = (TextView) findViewById(R.id.TXT_endGameText);
        JsonController jsonController = new JsonController();
        if(condition == true){
            TXT_endGameText.setText("hey du vandt FLOT du gættede ordet "+word+" på "+ attemps+ " forsøg");
            try {

                jsonController.SaveJsonObject(this,"du", word, attemps);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ListView LW_scoreBoard = (ListView) findViewById(R.id.LW_scoreBoard);
        try {
            ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1, jsonController.LoadJsonFile(this));
            LW_scoreBoard.setAdapter(arrayAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BTN_FrontView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
        // følgende måde at skifte view kommer herfra
        //https://www.learn2crack.com/2016/10/android-switching-between-activities-example.html#:~:text=In%20Android%20Studio%20select%20File,name%20for%20the%20XML%20layout.
    }


    private void launchActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
