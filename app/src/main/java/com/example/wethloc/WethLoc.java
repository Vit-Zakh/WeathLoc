package com.example.wethloc;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Locations_table")
public class WethLoc {
    @PrimaryKey(autoGenerate = true)
    private int id;

}
