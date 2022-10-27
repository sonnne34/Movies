package com.sonne.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDoc {

    @SerializedName("docs")
    private List<Movie> movieList;

    public MovieDoc(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    @Override
    public String toString() {
        return "MovieDoc{" +
                "movieList=" + movieList +
                '}';
    }
}
