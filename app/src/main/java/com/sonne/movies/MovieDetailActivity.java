package com.sonne.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String TAG = "MovieDetailActivity";
    private static final String EXTRA_MOVIE = "movie";

    private MovieDetailViewModel movieDetailViewModel;
    private ImageView imageViewPoster;
    private TextView textViewTitle;
    private TextView textViewYear;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        initView();
        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        Glide.with(this)
                .load(movie.getPoster().getUrl())
                .into(imageViewPoster);
        textViewTitle.setText(movie.getName());
        textViewYear.setText(String.valueOf(movie.getYear()));
        textViewDescription.setText(movie.getDescription());

        movieDetailViewModel = new ViewModelProvider(this).get(MovieDetailViewModel.class);
        //        movieDetailViewModel.loadTrailers(movie.getId());
        movieDetailViewModel.loadTrailers(545);
        movieDetailViewModel.getTrailers().observe(this, new Observer<List<Trailer>>() {
            @Override
            public void onChanged(List<Trailer> trailerList) {
                Log.d(TAG, trailerList.toString());
            }
        });
    }

    private void initView() {
        imageViewPoster = findViewById(R.id.imageViewPosterDetail);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewYear = findViewById(R.id.textViewYear);
        textViewDescription = findViewById(R.id.textViewDescription);
    }

    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }
}