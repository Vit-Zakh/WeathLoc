package com.example.wethloc;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocationsRepo {

    private LocationsDAO locationsDAO;
    private LiveData<List<WeathLoc>> allWeathLocs;

    public LocationsRepo(Application application) {
        LocationsRoomDB database = LocationsRoomDB.getInstance(application);
        locationsDAO = database.locationsDAO();
        allWeathLocs = locationsDAO.getAllWeathLocs();
    }

    LiveData<List<WeathLoc>> getAllWeathLocs(){
        return allWeathLocs;
    }

    void insert(WeathLoc weathLoc){
        new InsertAsyncTask(locationsDAO).execute(weathLoc);
    }

    private class InsertAsyncTask extends AsyncTask<WeathLoc, Void, Void> {
        private LocationsDAO asyncLocationsDAO;
        public InsertAsyncTask(LocationsDAO dao) {
            this.asyncLocationsDAO = dao;
        }

        @Override
        protected Void doInBackground(WeathLoc... weathLocs) {
            asyncLocationsDAO.insert(weathLocs[0]);
            return null;
        }
    }
}
