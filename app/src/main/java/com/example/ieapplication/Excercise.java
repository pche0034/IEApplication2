package com.example.ieapplication;

import android.icu.util.IndianCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;

public class Excercise extends AppCompatActivity {
    IndicatorSeekBar aerobic;
    IndicatorSeekBar strenght;
    IndicatorSeekBar flexibility;
    IndicatorSeekBar balance;
    ImageButton exc_save;
    DatabaseHelper_exc databaseHelper_exc;
    int indicator_flexibility,indicator_strength,indicator_aerobic,indicator_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);
        databaseHelper_exc=new DatabaseHelper_exc(this);
        aerobic=findViewById(R.id.seekBar1_exc);
        strenght=findViewById(R.id.seekBar2_exc);
        flexibility=findViewById(R.id.seekbar3_exc);
        balance=findViewById(R.id.seekBar4_exc);
        exc_save=findViewById(R.id.savebutton_exc);
        exc_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper_exc.insert_exc(indicator_aerobic,indicator_strength,indicator_flexibility,indicator_balance);

            }
        });
        aerobic.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
                indicator_aerobic=seekBar.getProgress();

            }

            @Override
            public void onDragging(float progress) {


            }
        });
        strenght.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {
                indicator_strength= seekBar.getProgress();

            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {

            }

            @Override
            public void onDragging(float progress) {

            }
        });
        flexibility.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
                indicator_flexibility=seekBar.getProgress();

            }

            @Override
            public void onDragging(float progress) {

            }
        });
        balance.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
                indicator_balance=seekBar.getProgress();

            }

            @Override
            public void onDragging(float progress) {

            }
        });
    }
}
