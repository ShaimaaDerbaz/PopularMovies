package com.example.shaimaaderbaz.popularmovies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shaimaa Derbaz on 2/24/2018.
 */

public class TrailerResults {
    @SerializedName("key")
    @Expose
    String trailer_key;

    public TrailerResults(String trailer_key) {
        this.trailer_key = trailer_key;
    }

    public String getTrailer_key() {
        return trailer_key;
    }

    public void setTrailer_key(String trailer_id) {
        this.trailer_key = trailer_id;
    }
}
