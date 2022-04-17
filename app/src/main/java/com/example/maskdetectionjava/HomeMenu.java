package com.example.maskdetectionjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.view.MenuItem;

public class HomeMenu  extends AppCompatActivity {

    BottomNavigationView botNavView;
    Home homeFragment = new Home();
    Timecard timecardFragment = new Timecard();
    Profile profileFragment = new Profile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        botNavView = findViewById(R.id.botNavView);
        botNavView.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,homeFragment).commit();

        botNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.profile) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).commit();
                    return true;
                }if(item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                    return true;
                }if(item.getItemId() == R.id.timecard){
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, timecardFragment).commit();
                    return true;
                }if(item.getItemId() == R.id.exit) {
                    //finish();
                    return true;
                }
                return false;
            }
        });

        //Badge marking code for toolbar
//        BadgeDrawable badgeDrawable = botNavView.getOrCreateBadge(R.id.notification);
//        badgeDrawable.setVisible(true);
//        badgeDrawable.setNumber(8);

    }
}

