package com.example.android.popmovies_1.database;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Grimlock on 7/17/18.
 */

public abstract class ParcelableViewModel extends ViewModel {

    public abstract void writeTo(@NonNull Bundle bundle);
    public abstract void readFrom(@NonNull Bundle bundle);
}