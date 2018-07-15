package com.example.android.popmovies_1;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Grimlock on 7/15/18.
 */

public class FavoriteViewModel extends ViewModel{

    private LiveData<MovieResults.ResultsBean> favorite;

    public FavoriteViewModel(FavoritesDatabase database, int movieId) {
        favorite = database.favoritesDao().loadFavoriteById(movieId);
    }

    private LiveData<MovieResults.ResultsBean> getFavorite(){
        return favorite;
    }



}
