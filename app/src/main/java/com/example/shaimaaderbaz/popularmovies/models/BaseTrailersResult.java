package com.example.shaimaaderbaz.popularmovies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/24/2018.
 */

public class BaseTrailersResult {
    @SerializedName("results")
    @Expose
    private List<TrailerResults> results;

    public BaseTrailersResult(List<TrailerResults> results) {
        this.results = results;
    }

    public List<TrailerResults> getResults() {
        return results;
    }

    public void setResults(List<TrailerResults> results) {
        this.results = results;
    }
}
