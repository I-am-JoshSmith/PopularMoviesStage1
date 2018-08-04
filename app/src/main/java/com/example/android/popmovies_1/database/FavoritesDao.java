package com.example.android.popmovies_1.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.android.popmovies_1.MovieResults;

import java.util.List;


/**
 * Created by Grimlock on 7/10/18.
 */
@Dao
public interface FavoritesDao {

    @android.arch.persistence.room.Query("SELECT * FROM favorites ORDER BY title")
    LiveData<List<MovieResults.ResultsBean>> loadAllMovies();
// added onConflict to supress app crashes while trying to figure out how to get fab button to work
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie (MovieResults.ResultsBean resultsBean);

    @Delete
    void deleteMovie(MovieResults.ResultsBean resultsBean);

    @Query("SELECT * FROM favorites WHERE title = :title")
    MovieResults.ResultsBean loadFavoriteByTitle(String title);


}
