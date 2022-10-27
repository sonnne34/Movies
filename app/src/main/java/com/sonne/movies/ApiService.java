package com.sonne.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("movie?field=rating.kp&search=7-10&sortField=votes.kp&&sortType=-1&limit=40&token=N98287Z-4CPMPGR-Q52GXHY-5QH05D2")
    Single<MovieDoc> getMovieDoc();
}
