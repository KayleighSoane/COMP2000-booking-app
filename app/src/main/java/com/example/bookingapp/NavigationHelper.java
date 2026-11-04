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

            if (id == R.id.rooms) { // if click on room icon
                if (!(activity instanceof RoomMain)) {
                    Intent intent = new Intent(activity, RoomMain.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear roomtemplate and roomdateemployee from stack as subscreens
                    activity.startActivity(intent);                  // So that if nav is pressed when on those screens, they go to roommain
                    activity.overridePendingTransition(0, 0); // No animation
                }
                return true;

            } else if (id == R.id.bookings) { // if click on booking icon
                if (!(activity instanceof MyBookings)) {
                    Intent intent = new Intent(activity, MyBookings.class); // same as above
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(0, 0);
                }
                return true;

            } else if (id == R.id.account) { // if click on account icon
                // activity.startActivity(new Intent(activity, Account.class));
                return true;
            }
            return false;
        });
    }
}