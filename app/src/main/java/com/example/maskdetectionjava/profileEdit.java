package com.example.maskdetectionjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class profileEdit extends Fragment {

    Spinner gender;
    Button cancel, confirm;
    EditText department_ET, jobTitle_ET;
    TextView name_TV;

    public profileEdit() {
        if(name_TV != null)
            refresh();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_profile_edit, container, false);

        cancel = view.findViewById(R.id.edit_cancel_btn);
        confirm = view.findViewById(R.id.edit_confirm_btn);
        gender = view.findViewById(R.id.gender_input_Spinner);
        department_ET = view.findViewById(R.id.department_input_ET);
        jobTitle_ET = view.findViewById(R.id.job_input_ET);
        name_TV = view.findViewById(R.id.name_input_TV);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(), R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        gender.setAdapter(adapter);

        refresh();

        confirm.setOnClickListener(v -> {
            submit();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new Profile()).commit();
        });

        cancel.setOnClickListener(v -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new Profile()).commit();
        });

        return view;
    }

    private void refresh(){
        switch(Data.currData.gender){
            case "Male":
                gender.setSelection(0);
                break;
            case "Female":
                gender.setSelection(1);
                break;
            case "Nonbinary":
                gender.setSelection(2);
                break;
            case "Other":
                gender.setSelection(3);
                break;
        }

        name_TV.setText(String.format("%s %s",Data.currData.firstName, Data.currData.lastName)); //
        department_ET.setText(Data.currData.department);
        jobTitle_ET.setText(Data.currData.jobTitle);

    }

    private void submit(){
        String[] splitted = name_TV.getText().toString().split("\\s+");
        Data.currData.firstName = splitted[0];
        Data.currData.lastName = splitted[1];
        Data.currData.gender = gender.getSelectedItem().toString();
        Data.currData.jobTitle = jobTitle_ET.getText().toString();
        Data.currData.department = department_ET.getText().toString();
    }

}