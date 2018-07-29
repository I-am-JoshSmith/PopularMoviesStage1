package com.example.android.popmovies_1.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.example.android.popmovies_1.MovieResults;


/**
 * Created by Grimlock on 7/10/18.
 */
@Database(entities = {MovieResults.ResultsBean.class}, version = 2, exportSchema = false)
public abstract class FavoritesDatabase extends RoomDatabase {

    private static final String LOG_TAG = FavoritesDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "favoritesList";
    private static FavoritesDatabase sInstance;

    public static FavoritesDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        FavoritesDatabase.class, FavoritesDatabase.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }
    public abstract FavoritesDao favoritesDao();
}
