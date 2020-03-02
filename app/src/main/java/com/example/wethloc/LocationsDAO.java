package com.example.wethloc;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LocationsDAO {

    @Insert
    void insert (WethLoc wethLoc);

    @Query("DELETE from Locations_table where id = :id")
    int deleteWethLock(int id);

    @Query("SELECT * from Locations_table")
    LiveData<List<WethLoc>> getAllWethLocs();

}
