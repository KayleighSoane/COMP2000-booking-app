package com.example.bookingapp;

import android.os.Bundle;
import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

public class RoomMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        NavigationHelper.setupBottomNav(this, R.id.rooms);
    }
}
// need to implement pressing on each room to go to room template