package com.example.android.popmovies_1.database;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


/**
 * Created by Grimlock on 7/17/18.
 */

public class MainActivityViewModelFactory<T extends ParcelableViewModel> implements ViewModelProvider.Factory {
    private final Bundle savedInstanceState;
    private final ViewModelProvider.Factory provider;

    public MainActivityViewModelFactory(@Nullable Bundle savedInstanceState, ViewModelProvider.Factory provider) {
        this.savedInstanceState = savedInstanceState;
        this.provider = provider;
    }
    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public T create(@NonNull final Class modelClass) {

        T viewModel = (T)provider.create(modelClass);
        if (savedInstanceState != null) {
            viewModel.readFrom(savedInstanceState);
        }
        return viewModel;
    }

}