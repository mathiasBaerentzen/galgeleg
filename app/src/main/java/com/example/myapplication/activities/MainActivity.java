package com.example.myapplication.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.activities.ActivityGame;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnView = (Button) findViewById(R.id.BTN_startGame);
        btnView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                launchActivity();
            }
        });
        // følgende måde at skifte view kommer herfra
        //https://www.learn2crack.com/2016/10/android-switching-between-activities-example.html#:~:text=In%20Android%20Studio%20select%20File,name%20for%20the%20XML%20layout.
    }


    private void launchActivity() {

        Intent intent = new Intent(this, ActivityGame.class);
        startActivity(intent);
    }
}