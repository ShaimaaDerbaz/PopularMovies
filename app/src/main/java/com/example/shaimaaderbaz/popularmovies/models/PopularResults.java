package com.example.shaimaaderbaz.popularmovies.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shaimaa Derbaz on 2/22/2018.
 */

public class PopularResults implements Parcelable {
    @SerializedName("id")
    @Expose
    long movie_id;
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("vote_average")
    @Expose
    double vote_average;
    @SerializedName("poster_path")
    @Expose
    String poster_path;
    @SerializedName("original_language")
    @Expose
    String original_language;
    @SerializedName("release_date")
    @Expose
    String release_date;
    @SerializedName("overview")
    @Expose
    String overview;
    public PopularResults(Parcel parcel)
    {
        this.movie_id = parcel.readLong();
        this.title = parcel.readString();
        this.vote_average = parcel.readDouble();
        this.poster_path = parcel.readString();
        this.original_language = parcel.readString();
        this.release_date=parcel.readString();
        this.overview = parcel.readString();
    }

    public PopularResults(long movie_id, String title, double vote_average, String poster_path, String original_language,String release_date, String overview) {
        this.movie_id = movie_id;
        this.title = title;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.release_date=release_date;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(movie_id);
        dest.writeString(title);
        dest.writeDouble(vote_average);
        dest.writeString(poster_path);
        dest.writeString(original_language);
        dest.writeString(release_date);
        dest.writeString(overview);
    }
    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Parcelable.Creator<PopularResults> CREATOR = new Parcelable.Creator<PopularResults>()
    {

        @Override
        public PopularResults createFromParcel(Parcel parcel)
        {
            return new PopularResults(parcel);
        }

        @Override
        public PopularResults[] newArray(int size) {
            return new PopularResults[0];
        }
    };
}
