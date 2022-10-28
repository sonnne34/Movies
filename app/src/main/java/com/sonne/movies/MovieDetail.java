package com.sonne.movies;

import com.google.gson.annotations.SerializedName;

public class MovieDetail {

    public MovieDetail(int id, String videos, Trailers trailers) {
        this.id = id;
        this.videos = videos;
        this.trailers = trailers;
    }

    @SerializedName("id")
    private int id;
    @SerializedName("videos")
    private String videos;
    @SerializedName("trailers")
    private Trailers trailers;

    public int getId() {
        return id;
    }

    public String getVideos() {
        return videos;
    }

    public Trailers getTrailers() {
        return trailers;
    }
}
