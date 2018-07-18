package com.example.android.popmovies_1.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.popmovies_1.MovieResults;
import com.example.android.popmovies_1.database.FavoritesDatabase;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by Grimlock on 7/13/18.
 */

public class MainViewModel extends AndroidViewModel{

    private LiveData<List<MovieResults.ResultsBean>> favorites;

    public MainViewModel(@NonNull Application application) {
        super(application);
        FavoritesDatabase database = FavoritesDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actrively retrieving favorites from Database");
        favorites = database.favoritesDao().loadAllMovies();
    }

    public LiveData<List<MovieResults.ResultsBean>> getFavorites() {
        return favorites;
    }


}
