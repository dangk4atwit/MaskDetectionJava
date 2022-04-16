package com.example.maskdetectionjava;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Timecard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timecard_layout);


        //initiate textviews
        TextView title = findViewById(R.id.Maintitle);
        TextView monTitle = findViewById(R.id.SubtitleMon);
        TextView tuesTitle = findViewById(R.id.SubTitleTues);
        TextView wedTitle = findViewById(R.id.SubTitleWed);
        TextView thursTitle = findViewById(R.id.SubTitleThur);
        TextView friTitle = findViewById(R.id.SubTitleFri);
        TextView satTitle = findViewById(R.id.SubTitleSat);
        TextView sunTitle = findViewById(R.id.SubTitleSun);

        //initiate edittime

    }
}