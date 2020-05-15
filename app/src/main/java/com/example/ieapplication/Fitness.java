package com.example.ieapplication;

import android.icu.util.IndianCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;

import java.util.ArrayList;

public class Fitness extends AppCompatActivity {
    IndicatorSeekBar indicatorSeekBar_fruit;
    IndicatorSeekBar indicatorSeekBar_vegetable;
    IndicatorSeekBar indicatorSeekBar_meat;
    IndicatorSeekBar indicatorSeekBar_diary;
    ImageButton save_button;
    DataBaseHelper_Food dataBaseHelperFood;
    int indicator_fruit,indicator_vegetable,indicator_diary,indicator_meat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBaseHelperFood= new DataBaseHelper_Food(this);
        setContentView(R.layout.activity_fitness);
        indicatorSeekBar_fruit= findViewById(R.id.seekBar2_fit);
        indicatorSeekBar_vegetable=findViewById(R.id.seekBar3_fit);
        indicatorSeekBar_diary=findViewById(R.id.seekBar4_fit);
        indicatorSeekBar_meat=findViewById(R.id.seekBar4_food);
        save_button=findViewById(R.id.savebutton_food);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelperFood.insert_food(indicator_fruit,indicator_vegetable,indicator_diary,indicator_meat);
            }
        });
        indicatorSeekBar_fruit.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {
                indicator_fruit=seekBar.getProgress();

            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {

            }

            @Override
            public void onDragging(float progress) {

            }
        });
        indicatorSeekBar_vegetable.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
                indicator_vegetable=seekBar.getProgress();

            }

            @Override
            public void onDragging(float progress) {

            }
        });
        indicatorSeekBar_diary.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {

            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {
                indicator_diary=seekBar.getProgress();

            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {

            }

            @Override
            public void onDragging(float progress) {

            }
        });



    }

}
