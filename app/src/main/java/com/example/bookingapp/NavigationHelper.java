package com.example.bookingapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationHelper {

    public static void setupBottomNav(AppCompatActivity activity, int currentTabId) {
        BottomNavigationView bottomNav = activity.findViewById(R.id.bottomNavigationView);
        if (bottomNav == null) return;

        // Highlight current tab icon
        bottomNav.setSelectedItemId(currentTabId);

        // Handle navigation clicks
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == currentTabId) return true; // Already on this screen

            if (id == R.id.rooms) {
                activity.startActivity(new Intent(activity, RoomMain.class));
                activity.overridePendingTransition(0, 0);
                return true;
            } else if (id == R.id.bookings) {
                activity.startActivity(new Intent(activity, MyBookings.class));
                activity.overridePendingTransition(0, 0);
                return true;
            } else if (id == R.id.account) {
                // activity.startActivity(new Intent(activity, Account.class));
                return true;
            }
            return false;
        });
    }
}