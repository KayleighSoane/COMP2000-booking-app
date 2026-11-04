package com.example.bookingapp;

import android.os.Bundle;
import android.view.View;
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

        View card1 = findViewById(R.id.cardRoom1);
        card1.setOnClickListener(v -> { // when clicked:
            Intent intent = new Intent(RoomMain.this, RoomTemplate.class); // go to room template
            intent.putExtra("roomImage", R.drawable.room1); // pass views to next activity
            intent.putExtra("roomName", "Room 1");
            intent.putExtra("roomCapacity", "4 people");
            intent.putExtra("roomIncludes", "Whiteboard, monitor");
            startActivity(intent);
        });

        View card2 = findViewById(R.id.cardRoom2);
        card2.setOnClickListener(v -> {
            Intent intent = new Intent(RoomMain.this, RoomTemplate.class);
            intent.putExtra("roomImage", R.drawable.room2);
            intent.putExtra("roomName", "Room 2");
            intent.putExtra("roomCapacity", "6 people");
            intent.putExtra("roomIncludes", "Whiteboard, presentation screen");
            startActivity(intent);
        });

        View card3 = findViewById(R.id.cardRoom3);
        card3.setOnClickListener(v -> {
            Intent intent = new Intent(RoomMain.this, RoomTemplate.class);
            intent.putExtra("roomImage", R.drawable.room3);
            intent.putExtra("roomName", "Room 3");
            intent.putExtra("roomCapacity", "8 people");
            intent.putExtra("roomIncludes", "Video-conferencing, large display screen");
            startActivity(intent);
        });

        View card4 = findViewById(R.id.cardRoom4);
        card4.setOnClickListener(v -> {
            Intent intent = new Intent(RoomMain.this, RoomTemplate.class);
            intent.putExtra("roomImage", R.drawable.room4);
            intent.putExtra("roomName", "Room 4");
            intent.putExtra("roomCapacity", "10 people");
            intent.putExtra("roomIncludes", "Presentation equipment, video-conferencing, whiteboard");
            startActivity(intent);
        });

        View card5 = findViewById(R.id.cardRoom5);
        card5.setOnClickListener(v -> {
            Intent intent = new Intent(RoomMain.this, RoomTemplate.class);
            intent.putExtra("roomImage", R.drawable.room5);
            intent.putExtra("roomName", "Room 5");
            intent.putExtra("roomCapacity", "12 people");
            intent.putExtra("roomIncludes", "Whiteboard, monitor");
            startActivity(intent);
        });

        View card6 = findViewById(R.id.cardRoom6);
        card6.setOnClickListener(v -> {
            Intent intent = new Intent(RoomMain.this, RoomTemplate.class);
            intent.putExtra("roomImage", R.drawable.room6);
            intent.putExtra("roomName", "Room 6");
            intent.putExtra("roomCapacity", "35 people");
            intent.putExtra("roomIncludes", "Projector, sound system");
            startActivity(intent);
        });

        View card7 = findViewById(R.id.cardRoom7);
        card7.setOnClickListener(v -> {
            Intent intent = new Intent(RoomMain.this, RoomTemplate.class);
            intent.putExtra("roomImage", R.drawable.room7);
            intent.putExtra("roomName", "Room 7");
            intent.putExtra("roomCapacity", "50 people");
            intent.putExtra("roomIncludes", "Projector, AV equipment, presentation facilities");
            startActivity(intent);
        });
    }
}
// need to implement pressing on each room to go to room template