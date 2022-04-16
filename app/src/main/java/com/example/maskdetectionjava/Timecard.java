package com.example.maskdetectionjava;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Timecard extends AppCompatActivity {
    int total, timeTotal;
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

    //intvalues
    int mon, mon2, tues, tues2, wed, wed2, thu, thu2, fri, fri2, sat, sat2, sun, sun2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timecard_layout);

        /**
        //initiate textviews
        TextView title = findViewById(R.id.Maintitle);
        TextView monTitle = findViewById(R.id.SubtitleMon);
        TextView tuesTitle = findViewById(R.id.SubTitleTues);
        TextView wedTitle = findViewById(R.id.SubTitleWed);
        TextView thursTitle = findViewById(R.id.SubTitleThur);
        TextView friTitle = findViewById(R.id.SubTitleFri);
        TextView satTitle = findViewById(R.id.SubTitleSat);
        TextView sunTitle = findViewById(R.id.SubTitleSun);*/

        //Button Initialize
        Button back = findViewById(R.id.button4);
        Button submit = findViewById(R.id.button5);

        //Time to int
        mon = textToInt(monIn);
        mon2 = textToInt(monOut);
        tues = textToInt(tueIn);
        tues2 =textToInt(tueOut);
        wed = textToInt(wedIn);
        wed2 = textToInt(wedOut);
        thu = textToInt(thuIn);
        thu2 = textToInt(thuOut);
        fri = textToInt(friIn);
        fri2 = textToInt(friOut);
        sat = textToInt(satIn);
        sat2 = textToInt(satOut);
        sun = textToInt(sunIn);
        sun2 = textToInt(sunOut);

        timeTotal = calculateHoursWorked();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Timecard.this, HomeMenu.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("timeTotal", timeTotal);
                intent.setClass(Timecard.this, HomeMenu.class);
                startActivity(intent);
            }
        });
    }
    public int textToInt(EditText text) {
        int n = Integer.parseInt(text.getText().toString());
        return n;
    }
    public int calculateHoursWorked() {
        total = (mon2-mon) + (tues2-tues) + (wed2-wed) + (thu2-thu) + (fri2-fri) + (sat2-sat) + (sun2-sun);
        return total;
    }
}