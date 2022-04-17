package com.example.maskdetectionjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Timecard extends Fragment {

    private ArrayList<Timecard_Day> dayList;
    private RecyclerView recyclerView;

    public Timecard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_timecard, container, false);

        recyclerView = view.findViewById(R.id.timeCard_RV);
        dayList = new ArrayList<>();

        createDays();
        setAdapter();

        return view;
    }

    private void setAdapter(){
        TimecardRecyclerAdapter adapter = new TimecardRecyclerAdapter(dayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void createDays(){
        dayList.add(new Timecard_Day("Monday"));
        dayList.add(new Timecard_Day("Tuesday"));
        dayList.add(new Timecard_Day("Wednesday"));
        dayList.add(new Timecard_Day("Thursday"));
        dayList.add(new Timecard_Day("Friday"));
        dayList.add(new Timecard_Day("Saturday"));
        dayList.add(new Timecard_Day("Sunday"));

    }
}