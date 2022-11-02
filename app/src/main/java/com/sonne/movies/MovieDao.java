package com.sonne.movies;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

public interface MovieDao {

    @Query("SELECT * FROM favourite_movies")
    LiveData<List<Movie>> getAllFavouriteMovies();

    @Query("SELECT * FROM favourite_movies WHERE id = :movieId")
    LiveData<Movie> getFavouriteMovie(int movieId);

    @Insert
    Completable insertMovie(Movie movie);

    @Query("DELETE FROM favourite_movies WHERE id = :movieId")
    Completable removeMovie(int movieId);
}
