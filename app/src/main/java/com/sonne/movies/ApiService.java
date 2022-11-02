package com.sonne.movies;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=N98287Z-4CPMPGR-Q52GXHY-5QH05D2&field=rating.kp&search=5-6&sortField=votes.kp&&sortType=-1&limit=30")
    Single<MovieDoc> getMovieDoc(@Query("page") int page);

    @GET("movie?token=N98287Z-4CPMPGR-Q52GXHY-5QH05D2&field=id")
    Single<TrailerResponse> loadTrailers(@Query("search") int id);

    @GET("review?token=N98287Z-4CPMPGR-Q52GXHY-5QH05D2&field=movieId&limit=10")
    Single<ReviewDoc> loadReview(@Query("search") int id);
}
