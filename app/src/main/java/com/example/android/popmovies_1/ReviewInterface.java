package com.example.android.popmovies_1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Grimlock on 7/3/18.
 */

public interface ReviewInterface {

    @GET("/3/movie/{id}/reviews")
    Call<ReviewResults> getReviews (
            @Path("id") String id,
            @Query("api_key") String apiKey,
            @Query("language") String language

    );
}
