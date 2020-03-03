package com.example.wethloc;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Locations_table")
public class WeathLoc {
    @PrimaryKey(autoGenerate = true)
    private int id;



}
