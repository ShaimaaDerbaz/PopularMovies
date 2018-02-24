package com.example.shaimaaderbaz.popularmovies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shaimaa Derbaz on 2/24/2018.
 */

public class TrailerResults {
    @SerializedName("id")
    @Expose
    String trailer_id;

    public TrailerResults(String trailer_id) {
        this.trailer_id = trailer_id;
    }

    public String getTrailer_id() {
        return trailer_id;
    }

    public void setTrailer_id(String trailer_id) {
        this.trailer_id = trailer_id;
    }
}
