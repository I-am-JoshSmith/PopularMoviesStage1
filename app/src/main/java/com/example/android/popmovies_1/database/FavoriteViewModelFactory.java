package com.example.android.popmovies_1.database;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;



public class FavoriteViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final FavoritesDatabase mDb;
    private final String myTitle;

    public FavoriteViewModelFactory(FavoritesDatabase database, String title) {

        mDb = database;
        myTitle = title;
    }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new FavoriteViewModel(mDb, myTitle);
    }
}
