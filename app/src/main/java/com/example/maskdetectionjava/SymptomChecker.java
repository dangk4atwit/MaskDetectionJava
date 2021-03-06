package com.example.maskdetectionjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SymptomChecker extends AppCompatActivity {
    // Define the object for Radio Group,
    // Submit and Clear buttons
    private RadioGroup radioGroup;
    Button submit, clear, back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptom_layout);

        // Bind the components to their respective objects
        // by assigning their IDs
        // with the help of findViewById() method
        submit = (Button)findViewById(R.id.submit_btn);
        back = (Button)findViewById(R.id.back_btn);
        radioGroup = (RadioGroup)findViewById(R.id.groupradio);

        // Uncheck or reset the radio buttons initially
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            // Check which radio button has been clicked
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Get the selected Radio Button
                RadioButton radioButton = (RadioButton)group.findViewById(checkedId);
            }
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(SymptomChecker.this, HomeMenu.class);
            startActivity(intent);
            finish();
        });

        // Add the Listener to the Submit Button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // When submit button is clicked,
                // Ge the Radio Button which is set
                // If no Radio Button is set, -1 will be returned
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(SymptomChecker.this, "No answer has been selected", Toast.LENGTH_SHORT).show();
                }

                //If no new symptoms is submitted green verified otherwise red and when submitted switch pages
                else {

                    RadioButton radioButton = (RadioButton)radioGroup.findViewById(selectedId);
                    if (radioGroup.indexOfChild(radioButton) == 0) {
                        Data.setSymptomCleared(true);
                    }else{
                        Data.setSymptomCleared(false);
                    }
                    // Now display the value of selected item
                    // by the Toast message
                    Toast.makeText(SymptomChecker.this, "Symptoms Submitted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(SymptomChecker.this, HomeMenu.class);
                    startActivity(intent);
                    finish();



                }
            }
        });

    }
}

