package com.example.ieapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public class About extends AppCompatActivity {
    private ImageButton fitness_button;
    private ImageButton sleep_button;
    private ImageButton symptoms_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        fitness_button=findViewById(R.id.imageButton2);
        fitness_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFitness();
            }
        });
        sleep_button=findViewById(R.id.imageButton3);
        sleep_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySleep();
            }
        });
        symptoms_button=findViewById(R.id.imageButton);
        symptoms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySymptoms();
            }
        });

    }
    public void openActivitySleep(){
        Intent intent_sleep= new Intent(this,Sleep.class);
        startActivity(intent_sleep);

    }
    public void openActivitySymptoms(){
        Intent intent_symptoms= new Intent(this,Symptoms.class);
        startActivity(intent_symptoms);

    }
    public void openActivityFitness(){
        Intent intent_fitness= new Intent(this,Fitness.class);
        startActivity(intent_fitness);

    }
}
