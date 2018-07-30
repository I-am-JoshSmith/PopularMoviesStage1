package com.example.android.popmovies_1.database;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;



public class FavoriteViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final FavoritesDatabase mDb;
    private final int movieId;

    public FavoriteViewModelFactory(FavoritesDatabase database, int id) {

        mDb = database;
        movieId = id;
    }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new FavoriteViewModel(mDb, movieId);
    }
}
