package com.example.maskdetectionjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;


public class Profile extends Fragment {

    TextView name_TV, department_TV, gender_TV, jobTitle_TV;

    ImageButton options;

    public Profile() {
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
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_profile, container, false);

        name_TV = view.findViewById(R.id.name_input_TV);
        department_TV = view.findViewById(R.id.department_input_TV);
        gender_TV = view.findViewById(R.id.gender_input_TV);
        jobTitle_TV = view.findViewById(R.id.job_input_TV);

        options = view.findViewById(R.id.profile_settings_btn);

        options.setOnClickListener(v -> {
            showOptions(options);
        });

        refresh();

        return view;
    }

    private void refresh(){
        name_TV.setText(String.format("%s %s",Data.currData.firstName, Data.currData.lastName));
        department_TV.setText(Data.currData.department);
        gender_TV.setText(Data.currData.gender);
        jobTitle_TV.setText(Data.currData.jobTitle);
    }

    private void showOptions(View v){
        PopupMenu popUp = new PopupMenu(getContext(), v);
        popUp.setOnMenuItemClickListener(m -> {
            switch(m.getItemId()){
                case R.id.edit:
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new profileEdit()).commit();
                    return true;
                default:
                    return false;
            }
        });
        popUp.inflate(R.menu.profile_menu);
        popUp.show();
    }

//    @Override
//    public boolean onMenuItemClick(MenuItem menuItem) {
//        switch(menuItem.getItemId()){
//            case R.id.edit:
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new profileEdit()).commit();
//                return true;
//            default:
//                return false;
//        }
//    }
}