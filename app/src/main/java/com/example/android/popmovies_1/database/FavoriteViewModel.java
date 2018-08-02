package com.example.android.popmovies_1.database;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.popmovies_1.MovieResults;

/**
 * Created by Grimlock on 7/15/18.
 */

public class FavoriteViewModel extends ViewModel{

    private LiveData<MovieResults.ResultsBean> favorite;

    public FavoriteViewModel(FavoritesDatabase database, String title) {
        favorite = database.favoritesDao().loadFavoriteByTitle(title);
    }

    public LiveData<MovieResults.ResultsBean> getFavorite(){
        return favorite;
    }



}
