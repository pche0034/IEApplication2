package com.example.ieapplication;

import android.icu.util.IndianCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;
import android.widget.Toast;

public class Excercise extends AppCompatActivity {
    IndicatorSeekBar aerobic;
    IndicatorSeekBar strenght;
    IndicatorSeekBar flexibility;
    IndicatorSeekBar balance;
    ImageButton exc_save;
    DatabaseHelper_exc databaseHelper_exc;
    private static  final String TAG="DataBaseHelper_Sleep";
    private static int EXCERCISE_UPDATED;
    int indicator_flexibility,indicator_strength,indicator_aerobic,indicator_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EXCERCISE_UPDATED=0;
        if (savedInstanceState != null) {
            EXCERCISE_UPDATED=savedInstanceState.getInt("UpdateValue");
        }
        else {
            EXCERCISE_UPDATED=0;
        }
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
               if(EXCERCISE_UPDATED==0) {
                   Log.d(TAG,"Excercise entered "+EXCERCISE_UPDATED);
                   databaseHelper_exc.insert_exc(indicator_aerobic, indicator_strength, indicator_flexibility, indicator_balance);
                   this.EXCERCISE_UPDATED=1;
                   Log.d(TAG,"Excercise entered "+EXCERCISE_UPDATED);
               }
               else{
                   Log.d(TAG,"Excercise going to update");

                   Toast.makeText(getApplicationContext(), "This is my Toast message!",
                           Toast.LENGTH_LONG).show();
                   databaseHelper_exc.update(indicator_aerobic, indicator_strength, indicator_flexibility, indicator_balance);

               }


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
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("UpdateValue",EXCERCISE_UPDATED);
        //savedInstanceState.putDouble("myDouble", 1.9);
        //savedInstanceState.putInt("MyInt", 1);
        //savedInstanceState.putString("MyString", "Welcome back to Android");
        // etc.
    }
}
