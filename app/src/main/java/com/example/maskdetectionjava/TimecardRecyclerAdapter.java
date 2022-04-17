package com.example.maskdetectionjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimecardRecyclerAdapter extends RecyclerView.Adapter<TimecardRecyclerAdapter.MyViewHolder>{

    private ArrayList<Timecard_Day> dayList;

    public TimecardRecyclerAdapter(ArrayList<Timecard_Day> dayList){
        this.dayList = dayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView day_TV;
        private EditText dayIn_ET, dayOut_ET;

        public MyViewHolder(final View view){
            super(view);
            day_TV = view.findViewById(R.id.daySubtitle);
            dayIn_ET = view.findViewById(R.id.dayIn);
            dayOut_ET = view.findViewById(R.id.dayOut);
        }
    }

    @NonNull
    @Override
    public TimecardRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.timecard_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TimecardRecyclerAdapter.MyViewHolder holder, int position) {
        String day = dayList.get(position).getDay();
        holder.day_TV.setText(String.format("Hours worked for %s:",day));
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }
}
