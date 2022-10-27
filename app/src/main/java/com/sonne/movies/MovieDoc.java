package com.sonne.movies;

import java.util.List;

public class MovieDoc {
    private List<Movie> movieList;

    public MovieDoc(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
