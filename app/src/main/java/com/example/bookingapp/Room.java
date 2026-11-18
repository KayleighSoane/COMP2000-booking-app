package com.example.bookingapp;

// this is the template fpr the room data of each room
public class Room {
    private final String name;
    private final String type;
    private final String capacity;
    private final String includes;
    private final String description;
    private final int imageResId;
    // private variables so they can only be accessed within the class
    // final so can't be modified

    public Room(String name, String type, String capacity, String includes, String description, int imageResId){
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.includes = includes;
        this.description = description;
        this.imageResId = imageResId; // this. means the current object
        // constructor - used to create a new object of this class
    }

    public String getName(){ return name; }
    public String getType(){ return type; }
    public String getCapacity(){ return capacity; }
    public String getIncludes(){ return includes; }
    public String getDescription(){ return description; }
    public int getImageResId(){ return imageResId; }
    // these getters allow the adapter to access the variables privately without exposing them
}
