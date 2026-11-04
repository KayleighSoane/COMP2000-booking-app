package com.example.bookingapp;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RoomDateEmployee extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roomdate_employee);

        NavigationHelper.setupBottomNav(this, R.id.rooms);

        Intent previntent = getIntent();
        int roomimage = previntent.getIntExtra("roomImage", R.drawable.room1);
        String selectedDate = previntent.getStringExtra("selectedDate");
        String roomName = previntent.getStringExtra("roomName");

        ImageView roomimageview = findViewById(R.id.imageView9);
        TextView date = findViewById(R.id.tvSelectedDate);
        TextView header = findViewById(R.id.rdeHeaderTitle);

        if (roomimageview != null) { roomimageview.setImageResource(roomimage); } // roomimageview.setImageResource(roomimageview)
        if (selectedDate != null) { date.setText(selectedDate); }
        if (roomName != null) { header.setText(roomName); }

        ImageButton backButton = findViewById(R.id.backbut);
        backButton.setOnClickListener(v -> {
            finish();
        });
    }
}
