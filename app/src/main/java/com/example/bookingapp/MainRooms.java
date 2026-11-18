package com.example.bookingapp;

import android.os.Bundle;
import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainRooms extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainrooms);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        NavigationHelper.setupBottomNav(this, R.id.rooms);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.bookingcardrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // cards scroll vertically

        // Calls getRoomData defined below
        List<Room> rooms = getRoomData();

        // Creates new adapter with room data and click listener
        RoomAdapter adapter = new RoomAdapter(rooms, room -> {
            Intent intent = new Intent(MainRooms.this, RoomDetails.class); // when room pressed, screen changes to roomtemplate with below data sent over
            intent.putExtra("roomImage", room.getImageResId());
            intent.putExtra("roomName", room.getName());
            intent.putExtra("roomType", room.getType());
            intent.putExtra("roomCapacity", room.getCapacity());
            intent.putExtra("roomIncludes", room.getIncludes());
            intent.putExtra("roomDescription", room.getDescription());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter); // binds adapter to recycler view so android can render the cards
    }

    private List<Room> getRoomData() {
        List<Room> list = new ArrayList<>();
        list.add(new Room("Room 1", "Meeting Room", "4", "Whiteboard, monitor", "Suitable for one-to-one meetings, interviews and small team discussions.", R.drawable.room1));
        list.add(new Room("Room 2", "Meeting Room","6", "Whiteboard, presentation screen", "Suitable for brainstorming sessions and project meetings.", R.drawable.room2));
        list.add(new Room("Room 3", "Meeting Room","8", "Video-conferencing, large display screen", "Suitable for regular team meetings and remote collaboration.", R.drawable.room3));
        list.add(new Room("Room 4", "Meeting Room","10", "Presentation equipment, video-conferencing, whiteboard", "Suitable for departmental meetings and client presentations.", R.drawable.room4));
        list.add(new Room("Room 5", "Meeting Room","12", "Whiteboard, monitor", "Suitable for one-to-one meetings, interviews and small team discussions.", R.drawable.room5));
        list.add(new Room("Room 6", "Seminar Room","35", "Projector, sound system", "Suitable for workshops, training sessions and presentations.", R.drawable.room6));
        list.add(new Room("Room 7", "Seminar Room","50", "AV equipment, presentation facilities", "Suitable for large presentations, staff briefings and training events.", R.drawable.room7));
        return list;
    } // data still links to roomdate and roomtemplate

}