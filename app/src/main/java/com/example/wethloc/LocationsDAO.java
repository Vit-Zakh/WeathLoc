package com.example.wethloc;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LocationsDAO {

    @Insert
    void insert (WeathLoc weathLoc);

    @Query("DELETE from Locations_table where id = :id")
    int deleteWeathLock(int id);

    @Query("SELECT * from Locations_table")
    LiveData<List<WeathLoc>> getAllWeathLocs();

    @Delete
    void delete(WeathLoc... weathLocs);

}
