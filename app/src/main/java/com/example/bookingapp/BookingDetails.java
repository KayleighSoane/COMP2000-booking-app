package com.example.bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BookingDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookingdetails);

        NavigationHelper.setupBottomNav(this, R.id.bookings);

        Intent previntent = getIntent(); // previntent is intent from mybookings
        int roomimage = previntent.getIntExtra("roomImage", R.drawable.room1);
        String roomname = previntent.getStringExtra("roomName");
        String roomdate = previntent.getStringExtra("roomDate");
        String roomtime = previntent.getStringExtra("roomTime");
        String roomstatus = previntent.getStringExtra("roomStatus");

        ImageView roomimageview = findViewById(R.id.imageView8);
        TextView roomnametext = findViewById(R.id.textView21);
        TextView roomdatetext = findViewById(R.id.textView22);
        TextView roomtimetext = findViewById(R.id.textView23);
        TextView roomstatustext = findViewById(R.id.textView25);

        if (roomimageview != null) { roomimageview.setImageResource(roomimage); }
        if (roomname != null) { roomnametext.setText(roomname); }
        if (roomdate != null) { roomdatetext.setText(roomdate); }
        if (roomtime != null) { roomtimetext.setText(roomtime); }
        if (roomstatus != null) { roomstatustext.setText(roomstatus); }

        ImageButton backButton = findViewById(R.id.backbut2);
        backButton.setOnClickListener(v -> {
            finish();
        });

        // Cancel Booking button
        Button btnCancelBooking = findViewById(R.id.button2);
        if (btnCancelBooking != null) { btnCancelBooking.setOnClickListener(v -> {
            showCancelBottomSheet(roomname, roomdate, roomtime);
            });
        }


    }

    private void showCancelBottomSheet(String roomName, String date, String time) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(BookingDetails.this);
        View sheetview = getLayoutInflater().inflate(R.layout.cancel_bottomsheet, null); // inflate the bottom sheet
        bottomSheetDialog.setContentView(sheetview);

        if (bottomSheetDialog.getWindow() != null) {
            bottomSheetDialog.getWindow().findViewById(com.google.android.material.R.id.design_bottom_sheet)
                    .setBackgroundResource(android.R.color.transparent); // ets background transparent instead of white
        }

        TextView cancelroom = sheetview.findViewById(R.id.tvRoom);
        TextView canceldate = sheetview.findViewById(R.id.textView8);
        TextView canceltime = sheetview.findViewById(R.id.textView9);
        Button cancelbutton = sheetview.findViewById(R.id.btnCancelSheet);

        if (cancelroom != null) { cancelroom.setText(roomName); }
        if (canceldate != null) { canceldate.setText(date); }
        if (canceltime != null) { canceltime.setText(time); }

        if(cancelbutton != null) {
            cancelbutton.setOnClickListener(v -> {
                bottomSheetDialog.dismiss();
                finish();
            });

        }

        bottomSheetDialog.show();
    }
}
