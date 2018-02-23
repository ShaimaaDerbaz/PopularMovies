package com.example.shaimaaderbaz.popularmovies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shaimaa Derbaz on 2/23/2018.
 */

public class ReviewsResults {

    @SerializedName("author")
    @Expose
    String author;
    @SerializedName("content")
    @Expose
    String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
