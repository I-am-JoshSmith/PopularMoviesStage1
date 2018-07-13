package com.example.android.popmovies_1;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


/**
 * Created by Grimlock on 7/10/18.
 */
@Dao
public interface FavoritesDao {

    @android.arch.persistence.room.Query("SELECT * FROM favorites ORDER BY id")
    List<MovieResults.ResultsBean> loadAllMovies();

    @Insert
    void insertMovie (MovieResults.ResultsBean resultsBean);

    @Delete
    void deleteMovie(MovieResults.ResultsBean resultsBean);

    /*
    @Query("SELECT * FROM favorites WHERE id = :id")
    LiveData<MovieResults.ResultsBean> loadFavoriteById(int id);
    */
}
