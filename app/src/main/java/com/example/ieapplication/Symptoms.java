package com.example.ieapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import com.xw.repo.BubbleSeekBar;


public class Symptoms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);


        BubbleSeekBar seekBar = findViewById(R.id.seekbar);
        if (seekBar != null) {
            seekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
                @Override
                public void onProgressChanged(int progress, float progressFloat) {

                }

                @Override
                public void getProgressOnActionUp(int progress, float progressFloat) {

                }

                @Override
                public void getProgressOnFinally(int progress, float progressFloat) {

                }
            });
        }
    }

}

