package com.example.ieapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;


public class Analatics extends AppCompatActivity {

    DataBaseHelper_Sleep dataBaseHelper_sleep;
    private List<DataEntry> values;
    private  AnyChartView anyChartView;
    private Cartesian cartesian;
    private static  final String TAG="DataBaseHelper_Sleep";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_analatics);
        FloatingActionButton fab = findViewById(R.id.fab);
        dataBaseHelper_sleep=new DataBaseHelper_Sleep(this);
        values=new ArrayList<>();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        anyChartView = findViewById(R.id.chart);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));
        cartesian = AnyChart.line();

        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        fetch_data();



    }

    public void fetch_data(){
        Log.d(TAG,"Fetching Started");
        Cursor fetched_data=dataBaseHelper_sleep.getData();
        Log.d(TAG,"Fetching Finished" + fetched_data.getCount());
        fetched_data.moveToFirst();
        while(!fetched_data.isAfterLast()) {
            String day=fetched_data.getString(fetched_data.getColumnIndex("id"));
            int value=fetched_data.getInt(fetched_data.getColumnIndex("sleep_duration"));
            Log.d(TAG, String.valueOf(value));
            values.add(new ValueDataEntry(day,value));
            fetched_data.moveToNext();
        }
        cartesian.data(values);
        anyChartView.setChart(cartesian);
    }



}
