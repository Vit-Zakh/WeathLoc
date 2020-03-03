package com.example.wethloc;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LocationsViewModel extends AndroidViewModel {

    private LocationsRepo locationsRepo;
    private LiveData<List<WeathLoc>> allWethLocs;

    public LocationsViewModel(@NonNull Application application) {
        super(application);
        locationsRepo = new LocationsRepo(application);
        allWethLocs = locationsRepo.getAllWeathLocs();
    }
    LiveData<List<WeathLoc>> getAllWethLocs(){
        return allWethLocs;
    }
    public void insert(WeathLoc weathLoc){
        locationsRepo.insert(weathLoc);
    }
}
