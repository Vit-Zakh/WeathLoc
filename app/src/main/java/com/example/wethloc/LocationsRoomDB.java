package com.example.wethloc;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WethLoc.class}, version = 1)
abstract class LocationsRoomDB extends RoomDatabase {

    public abstract LocationsDAO locationsDAO();
    private static volatile LocationsRoomDB INSTANCE;

    public static LocationsRoomDB getInstance(final Context context)
    {
        if (INSTANCE == null){
            synchronized (LocationsRoomDB.class){
                if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LocationsRoomDB.class, "LocationsDB")
                        .build();
                }
            }
        }
        return INSTANCE;
    }

    private LocationsRoomDB() {
    }
}
