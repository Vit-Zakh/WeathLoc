package com.example.wethloc;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocationsRepo {

    private LocationsDAO locationsDAO;
    private LiveData<List<WethLoc>> allWethLocs;

    public LocationsRepo(Application application) {
        LocationsRoomDB database = LocationsRoomDB.getInstance(application);
        locationsDAO = database.locationsDAO();
        allWethLocs = locationsDAO.getAllWethLocs();
    }

    LiveData<List<WethLoc>> getAllWethLocs(){
        return allWethLocs;
    }

    void insert(WethLoc wethLoc){
        new InsertAsyncTask(locationsDAO).execute(wethLoc);
    }

    private class InsertAsyncTask extends AsyncTask<WethLoc, Void, Void> {
        private LocationsDAO asyncLocationsDAO;
        public InsertAsyncTask(LocationsDAO dao) {
            this.asyncLocationsDAO = dao;
        }

        @Override
        protected Void doInBackground(WethLoc... wethLocs) {
            asyncLocationsDAO.insert(wethLocs[0]);
            return null;
        }
    }
}
