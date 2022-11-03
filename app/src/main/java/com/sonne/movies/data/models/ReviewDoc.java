package com.sonne.movies.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewDoc {

    @SerializedName("docs")
    private List<Review> reviewList;

    public ReviewDoc(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    @Override
    public String toString() {
        return "ReviewDoc{" +
                "reviewList=" + reviewList +
                '}';
    }
}
