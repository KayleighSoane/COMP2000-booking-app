package com.example.bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MyBookings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mybookings);

        NavigationHelper.setupBottomNav(this, R.id.bookings);

        View booking1 = findViewById(R.id.protobooking);
        booking1.setOnClickListener(v -> {
            Intent intent = new Intent(MyBookings.this, BookingDetails.class);
            intent.putExtra("roomImage", R.drawable.room3);
            intent.putExtra("roomName", "Room 3");
            intent.putExtra("roomDate", "Tue 3 November");
            intent.putExtra("roomTime", "08:00 - 08:45");
            intent.putExtra("roomStatus", "Approved");
            startActivity(intent);
        });
    }
}
