package com.example.shaimaaderbaz.popularmovies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/22/2018.
 */

public class BasePopularResult {
    @SerializedName("total_results")
    @Expose
    private long total_results;
    @SerializedName("results")
    @Expose
    private List<PopularResults> results;

    public BasePopularResult(List<PopularResults> results, long total_results) {
        this.results = results;
        this.total_results = total_results;
    }

    public long getTotalResults() {
        return total_results;
    }

    public void setTotalResults(long total_results) {
        this.total_results = total_results;
    }

    public List<PopularResults> getResults() {
        return results;
    }

    public void setResults(List<PopularResults> results) {
        this.results = results;
    }

    }
