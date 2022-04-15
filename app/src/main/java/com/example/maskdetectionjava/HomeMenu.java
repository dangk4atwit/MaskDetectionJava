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

public class HomeMenu  extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView botNavView;
    Button cambutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        botNavView = findViewById(R.id.botNavView);

        botNavView.setOnItemSelectedListener(this);
        botNavView.setSelectedItemId(R.id.home);

        cambutton = findViewById(R.id.button3);
        cambutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maskintent = new Intent();
                maskintent.setClass(HomeMenu.this,Mask.class);
                startActivity(maskintent);
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.profile) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                return true;
            }if(item.getItemId() == R.id.home) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                return true;
            }if(item.getItemId() == R.id.timecard){
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                return true;
            }if(item.getItemId() == R.id.exit) {
                finish();
                return true;
            }
            return false;
    }
}

