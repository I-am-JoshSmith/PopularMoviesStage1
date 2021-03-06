package com.example.android.popmovies_1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Grimlock on 7/3/18.
 */

public interface TrailerInterface {

         /* asyncronous thread of type MovieResults - method = getMovies
    Call is built from
    https://api.themoviedb.org/3/movie/popular?api_key=fdde22f0d62c95d575ee71100a498507&language=en-US&page=1
    */

    @GET("/3/movie/{id}/videos")
    Call<TrailerResults> getTrailers(
            @Path("id") String id,
            @Query("api_key") String apiKey,
            @Query("language") String language

    );


}

