package com.example.shaimaaderbaz.popularmovies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/23/2018.
 */

public class BaseReviewsResult {
    @SerializedName("results")
    @Expose
    private List<ReviewsResults> results;

    public List<ReviewsResults> getResults() {
        return results;
    }

    public void setResults(List<ReviewsResults> results) {
        this.results = results;
    }
}
