package com.example.wethloc;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LocationsViewModel extends AndroidViewModel {

    private LocationsRepo locationsRepo;
    private LiveData<List<WethLoc>> allWethLocs;

    public LocationsViewModel(@NonNull Application application) {
        super(application);
        locationsRepo = new LocationsRepo(application);
        allWethLocs = locationsRepo.getAllWethLocs();
    }
    LiveData<List<WethLoc>> getAllWethLocs(){
        return allWethLocs;
    }
    public void insert(WethLoc wethLoc){
        locationsRepo.insert(wethLoc);
    }
}
