package com.example.maskdetectionjava;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends Fragment {

    ImageButton cambutton, testButton;
    TextView clearedText, nameText;
    ImageView profileImageView;
    ConstraintLayout clearedCL;

    public Home() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        profileImageView = view.findViewById(R.id.clear_icon_imgview);
        profileImageView.setImageResource(Data.currData.profileImageID);
        clearedCL = view.findViewById(R.id.clear_display_GL);
        clearedText = view.findViewById(R.id.cleared_text_view);
        nameText = view.findViewById(R.id.name_TV);
        if(Data.currData.cleared){
            clearedCL.setBackgroundColor(Color.GREEN);
            clearedText.setText("Cleared");
        }else{
            clearedCL.setBackgroundColor(Color.RED);
            clearedText.setText("Restricted");
        }
        nameText.setText(String.format("%s %s",Data.currData.firstName, Data.currData.lastName));
        cambutton = view.findViewById(R.id.mask_btn);
        cambutton.setOnClickListener(v -> {
                Intent maskintent = new Intent();
                maskintent.setClass(getActivity(),Mask.class);
                startActivity(maskintent);
        });

        testButton = view.findViewById(R.id.test_btn);
        testButton.setOnClickListener(v -> {
            //Intent testIntent = new Intent();
            //testIntent.setClass(getActivity(),ScreenSliderPagerActivity.class);
            //startActivity(testintent);
            return;
        });
        return view;
    }
}