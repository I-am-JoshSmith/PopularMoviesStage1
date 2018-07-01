package com.example.android.popmovies_1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Grimlock on 6/13/18.
 */

public interface ApiInterface {

    //need to implement {category} swich via app menubar

     /* asyncronous thread of type MovieResults - method = getMovies
    Call is built from
    https://api.themoviedb.org/3/movie/popular?api_key=fdde22f0d62c95d575ee71100a498507&language=en-US&page=1
    */

    @GET("/3/movie/{category}")
    Call<MovieResults> getMovies(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page

    );


}
