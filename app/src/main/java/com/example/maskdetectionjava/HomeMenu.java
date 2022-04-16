package com.example.maskdetectionjava;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeMenu  extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView botNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        botNavView = findViewById(R.id.botNavView);

        botNavView.setOnItemSelectedListener(this);
        botNavView.setSelectedItemId(R.id.home);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new Home()).commit();
                return true;
            }if(item.getItemId() == R.id.home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new Home()).commit();
                return true;
            }if(item.getItemId() == R.id.timecard){
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new Home()).commit();
                return true;
            }if(item.getItemId() == R.id.exit) {
                finish();
                return true;
            }
            return false;
    }
}

