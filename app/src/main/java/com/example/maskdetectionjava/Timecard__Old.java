package com.example.maskdetectionjava;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Timecard__Old extends AppCompatActivity {
    float total;



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
        EditText monIn = findViewById(R.id.MonIn);
        EditText monOut = findViewById(R.id.MonOut);
        EditText tueIn = findViewById(R.id.TuesIn);
        EditText tueOut = findViewById(R.id.TuesOut);
        EditText wedIn = findViewById(R.id.WedIn);
        EditText wedOut = findViewById(R.id.WedOut);
        EditText friIn = findViewById(R.id.FriIn);
        EditText friOut = findViewById(R.id.FriOut);
        EditText satIn = findViewById(R.id.SatIn);
        EditText satOut = findViewById(R.id.SatOut);
        EditText thuIn = findViewById(R.id.ThurIn);
        EditText thuOut = findViewById(R.id.ThurOut);
        EditText sunIn = findViewById(R.id.SundayIn);
        EditText sunOut = findViewById(R.id.SundayOut);

    }
    public void calculateHoursWorked() {

    }
}