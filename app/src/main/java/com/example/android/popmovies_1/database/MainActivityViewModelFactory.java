package com.example.android.popmovies_1.database;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.android.popmovies_1.MainActivity;

/**
 * Created by Grimlock on 7/17/18.
 */

class MainActivityViewModelFactory<T extends ParcelableViewModel> implements ViewModelProvider.Factory {
    private final Bundle bundle;
    private final ViewModelProvider.Factory provider;
    public MainActivityViewModelFactory(@Nullable Bundle bundle,
                                       ViewModelProvider.Factory provider) {
        this.bundle = bundle;
        this.provider = provider;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T create(final Class modelClass) {

        T viewModel = (T)provider.create(modelClass);
        if (bundle != null) {
            viewModel.readFrom(bundle);
        }
        return viewModel;
    }

}