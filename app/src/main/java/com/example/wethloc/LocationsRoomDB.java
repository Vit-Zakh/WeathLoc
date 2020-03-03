package com.example.wethloc;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {WeathLoc.class}, version = 1)
abstract class LocationsRoomDB extends RoomDatabase {

    public abstract LocationsDAO locationsDAO();
    private static volatile LocationsRoomDB INSTANCE;

    static LocationsRoomDB getInstance(final Context context)
    {
        if (INSTANCE == null){
            synchronized (LocationsRoomDB.class){
                if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LocationsRoomDB.class, "LocationsDB")
                        .addCallback(roomDBCallback)
                        .build();
                }
            }
        }
        return INSTANCE;
    }

//    private LocationsRoomDB() {
//    }

    private static RoomDatabase.Callback roomDBCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDBAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDBAsync extends AsyncTask<Void, Void, Void> {
        private final LocationsDAO locationsDAO;
        public PopulateDBAsync(LocationsRoomDB instance) {
            locationsDAO = instance.locationsDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            locationsDAO.delete();
            return null;
        }
    }
}
