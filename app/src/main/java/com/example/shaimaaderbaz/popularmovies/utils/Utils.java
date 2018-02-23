package com.example.shaimaaderbaz.popularmovies.utils;

/**
 * Created by Shaimaa Derbaz on 2/3/2018.
 */

public class Utils {

    public static final String BASE_URL = "http://api.themoviedb.org/3/movie/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
