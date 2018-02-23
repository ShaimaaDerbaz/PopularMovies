package com.example.shaimaaderbaz.popularmovies.utils;

/**
 * Created by Shaimaa Derbaz on 2/21/2018.
 */

import com.example.shaimaaderbaz.popularmovies.models.BasePopularResult;
import com.example.shaimaaderbaz.popularmovies.models.BaseReviewsResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SOService {


    @GET("popular?api_key=3c8bc3decd1ba3fee7ca47b02d020343")
    Call<BasePopularResult> getMovies();

    /*Call<BaseResponseResult> getMovies(@Query("type")double type,
                                           @Query("features")FeaturesResults features,
                                           @Query("bbox")int [] bbox
                                   );*/

    @GET("{movie_id}/reviews?api_key=3c8bc3decd1ba3fee7ca47b02d020343")
    Call<BaseReviewsResult> getReviews(@Path("movie_id") long movie_id);
}