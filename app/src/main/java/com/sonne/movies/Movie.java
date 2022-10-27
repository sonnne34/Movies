package com.sonne.movies;

public class Movie {
    private String id;
    private String name;
    private String description;
    private String year;

    private Poster poster;
    private Rating rating;

    public Movie(String id, String name, String description, String year, Poster poster, Rating rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.year = year;
        this.poster = poster;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getYear() {
        return year;
    }

    public Poster getPoster() {
        return poster;
    }

    public Rating getRating() {
        return rating;
    }
}
