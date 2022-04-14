package com.example.maskdetectionjava;

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
    Button submit, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the components to their respective objects
        // by assigning their IDs
        // with the help of findViewById() method
        submit = (Button)findViewById(R.id.submit);
        radioGroup = (RadioGroup)findViewById(R.id.groupradio);

        // Uncheck or reset the radio buttons initially
        radioGroup.clearCheck();

        // Add the Listener to the RadioGroup
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                    }
                });

        // Add the Listener to the Submit Button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

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

                    // Now display the value of selected item
                    // by the Toast message
                    //Toast.makeText(SymptomChecker.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

