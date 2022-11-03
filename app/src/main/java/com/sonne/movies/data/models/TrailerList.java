package com.sonne.movies.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailerList {

    public TrailerList(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    @SerializedName("trailers")
    private List<Trailer> trailers;

    public List<Trailer> getTrailers() {
        return trailers;
    }

    @Override
    public String toString() {
        return "TrailerList{" +
                "trailers=" + trailers +
                '}';
    }
}
