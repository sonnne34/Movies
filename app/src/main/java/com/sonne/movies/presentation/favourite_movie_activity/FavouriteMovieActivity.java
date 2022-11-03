package com.sonne.movies.presentation.favourite_movie_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sonne.movies.R;
import com.sonne.movies.data.models.Movie;
import com.sonne.movies.presentation.adapters.MoviesAdapter;
import com.sonne.movies.presentation.movie_detail_activity.MovieDetailActivity;

import java.util.List;

public class FavouriteMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_movie);

        RecyclerView rvFavouritesMovies = findViewById(R.id.rvFavouritesMovies);
        MoviesAdapter moviesAdapter = new MoviesAdapter();
        rvFavouritesMovies.setLayoutManager(new GridLayoutManager(this, 2));
        rvFavouritesMovies.setAdapter(moviesAdapter);

        moviesAdapter.setOnMovieClickListener(new MoviesAdapter.OnMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(
                        FavouriteMovieActivity.this,
                        movie
                );
                startActivity(intent);
            }
        });

        FavouriteMoviesViewModel viewModel = new ViewModelProvider(this).get(
                FavouriteMoviesViewModel.class
        );

        viewModel.getFavouriteMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesAdapter.setMovieList(movies);
            }
        });
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, FavouriteMovieActivity.class);
    }
}