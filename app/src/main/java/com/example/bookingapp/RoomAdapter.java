package com.example.bookingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    public interface OnRoomClickListener {
        void onRoomClick(Room room);
    } // when a card is tapped, method is triggered

    private final List<Room> roomList; // declares variable to hold all rooms in a list. defined in RoomMain.java
    private final OnRoomClickListener clickListener; // action to take when room is tapped

    // constructor - receives list of rooms and click listener to save in their assigned variables
    // room list is taken from RoomMain.java and stored in roomList
    // click listener is taken from RoomMain.java and stored in clickListener
    public RoomAdapter(List<Room> roomList, OnRoomClickListener clickListener) {
        this.roomList = roomList;
        this.clickListener = clickListener;
    }

    // links to the room card template
    static class RoomViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSubtitle;
        TextView tvTypetitle;
        ImageView imageView;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView); // super means the parent class
            tvTitle = itemView.findViewById(R.id.titleRoom1);
            tvTypetitle = itemView.findViewById(R.id.textView1);
            tvSubtitle = itemView.findViewById(R.id.textView3);
            imageView = itemView.findViewById(R.id.imageView1);
        } // constructor, connects the views to the corresponding variables from roomcardtemplate
    }


    // creates room card
    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.roomcardtemplate, parent, false);
        return new RoomViewHolder(view);
    }


    @Override // binds data to room cards
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = roomList.get(position);
        holder.tvTitle.setText(room.getName());
        holder.tvTypetitle.setText(room.getType());
        holder.tvSubtitle.setText("Capacity: " + room.getCapacity());
        holder.imageView.setImageResource(room.getImageResId());
        holder.itemView.setOnClickListener(v -> clickListener.onRoomClick(room));
    }


    // identifies number of cards to render based on room list size
    @Override
    public int getItemCount() {
        return roomList.size();
    }

}
