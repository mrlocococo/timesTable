package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable(int timesTableNumber) {

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 10; j++) {

            timesTableContent.add(Integer.toString(j * timesTableNumber));

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesSeekBar = findViewById(R.id.timesSeekBar);

        timesTableListView = findViewById(R.id.timesTableListView);

        timesSeekBar.setMax(20);
        timesSeekBar.setProgress(10);

        timesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (i < min) {
                    timesTableNumber = min;
                } else {
                    timesTableNumber = i;
                }

                Log.i("Seekbar Value", Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}