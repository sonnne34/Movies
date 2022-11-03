package com.sonne.movies.data.models;

import com.google.gson.annotations.SerializedName;

public class Review {

    public Review(String author, String type, String review) {
        this.author = author;
        this.type = type;
        this.review = review;
    }

    @SerializedName("author")
    private String author;

    @SerializedName("type")
    private String type;

    @SerializedName("review")
    private String review;

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
