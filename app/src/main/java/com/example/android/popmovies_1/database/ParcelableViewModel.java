package com.example.android.popmovies_1.database;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Grimlock on 7/17/18.
 */

public abstract class ParcelableViewModel extends ViewModel {

public ParcelableViewModel (){}

    public abstract void writeTo(@NonNull Bundle savedInstanceState);
    public abstract void readFrom(@NonNull Bundle savedInstanceState);


}