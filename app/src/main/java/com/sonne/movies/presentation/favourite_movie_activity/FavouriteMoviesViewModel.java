package com.sonne.movies.presentation.favourite_movie_activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sonne.movies.data.models.Movie;
import com.sonne.movies.data.database.MovieDao;
import com.sonne.movies.data.database.MovieDatabase;

import java.util.List;

public class FavouriteMoviesViewModel extends AndroidViewModel {

    private final MovieDao movieDao;

    public FavouriteMoviesViewModel(@NonNull Application application) {
        super(application);
        movieDao = MovieDatabase.getInstance(application).movieDao();
    }

    public LiveData<List<Movie>> getFavouriteMovie() {
        return movieDao.getAllFavouriteMovies();
    }
}
