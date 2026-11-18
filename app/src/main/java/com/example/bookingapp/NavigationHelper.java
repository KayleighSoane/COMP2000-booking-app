package com.example.bookingapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class NavigationHelper {

    public static void setupBottomNav(AppCompatActivity activity, int currentTabId) {
        NavigationBarView nav = activity.findViewById(R.id.bottomNavigationView);
        if (nav == null) { nav = activity.findViewById(R.id.navigationRailView); }
        if (nav == null) { return; }

        // Highlight current tab icon
        nav.setSelectedItemId(currentTabId);

        // Handle navigation clicks
        nav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.rooms) { // if click on room icon
                if (!(activity instanceof MainRooms)) {
                    Intent intent = new Intent(activity, MainRooms.class);
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