package com.example.shaimaaderbaz.popularmovies.utils;

/**
 * Created by Shaimaa Derbaz on 2/21/2018.
 */

import com.example.shaimaaderbaz.popularmovies.models.BaseResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {


    @GET("popular?api_key=3c8bc3decd1ba3fee7ca47b02d020343")
    Call<BaseResponseResult> getMovies();

    /*Call<BaseResponseResult> getMovies(@Query("type")double type,
                                           @Query("features")FeaturesResults features,
                                           @Query("bbox")int [] bbox
                                   );*/

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<BaseResponseResult> getAnswers(@Query("tagged") String tags);
}