package com.example.barry.firestorerecyclerviewui;

/**
 * 1. add the 3 fields in our note_item.xml
 * 2. create a constructor
 * 3. create an empty constructor
 * 4. add the getters
 */


public class Note {

    private String title;
    private String description;
    private int priority;

    //3. create an empty constructor
    public Note() {
        // an empty constructor required
    }

    //2. create a constructor
    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    //4. add the getters

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
