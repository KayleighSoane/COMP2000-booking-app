package com.example.bookingapp;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CalendarView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RoomTemplate extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.room_template);

        NavigationHelper.setupBottomNav(this, R.id.rooms);

        Intent previntent = getIntent();
        int roomimage = previntent.getIntExtra("roomImage", R.drawable.room1);
        String roomname = previntent.getStringExtra("roomName");
        String roomcapacity = previntent.getStringExtra("roomCapacity");
        String roomincludes = previntent.getStringExtra("roomIncludes");
        // get variables set for each room in RoomMain
        ImageView roomimageview = findViewById(R.id.imageView7);
        TextView roomheader = findViewById(R.id.rtHeaderTitle);
        TextView roomcapacitytext = findViewById(R.id.textView15);
        TextView roomincludestext = findViewById(R.id.textView16);
        // put variables into views
        if (roomimageview != null) { roomimageview.setImageResource(roomimage); }
        if (roomname != null) { roomheader.setText(roomname); }
        if (roomcapacity != null) { roomcapacitytext.setText(String.valueOf(roomcapacity)); }
        if (roomincludes != null) { roomincludestext.setText(roomincludes); }

        ImageButton backButton = findViewById(R.id.backbtn);
        backButton.setOnClickListener(v -> {
            finish();
        });

        CalendarView calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) { // selects date
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, dayOfMonth);

                SimpleDateFormat formatter = new SimpleDateFormat("EEE d MMMM", Locale.getDefault()); // output date as day, number, month
                String selectedDate = formatter.format(cal.getTime());

                Intent intent = new Intent(RoomTemplate.this, RoomDateEmployee.class); // go to roomdateemployee
                intent.putExtra("roomImage", roomimage);
                intent.putExtra("selectedDate", selectedDate); // date shows up in roomdateemployee at
                intent.putExtra("roomName", roomname != null ? roomname : "Room 1"); // ? = if roomname is not null, use it, otherwise use "Room 1"
                startActivity(intent);

            }
        });
    }
}
