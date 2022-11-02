package com.sonne.movies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MovieDetailActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE = "movie";

    private MovieDetailViewModel movieDetailViewModel;
    private ImageView imageViewPoster;
    private TextView textViewTitle;
    private TextView textViewYear;
    private TextView textViewDescription;

    private RecyclerView trailersRecyclerView;
    private RecyclerView reviewsRecyclerView;
    private TrailersAdapter trailersAdapter;
    private ReviewsAdapter reviewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        initView();
        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        trailersRecyclerView = findViewById(R.id.rvTrailer);
        trailersAdapter = new TrailersAdapter();
        trailersRecyclerView.setAdapter(trailersAdapter);

        reviewsRecyclerView = findViewById(R.id.rvReview);
        reviewsAdapter = new ReviewsAdapter();
        reviewsRecyclerView.setAdapter(reviewsAdapter);

        Glide.with(this)
                .load(movie.getPoster().getUrl())
                .into(imageViewPoster);
        textViewTitle.setText(movie.getName());
        textViewYear.setText(String.valueOf(movie.getYear()));
        textViewDescription.setText(movie.getDescription());

        movieDetailViewModel = new ViewModelProvider(this).get(MovieDetailViewModel.class);
        //        movieDetailViewModel.loadTrailers(movie.getId());
        movieDetailViewModel.loadTrailers(525);
        movieDetailViewModel.getTrailers().observe(this, new Observer<List<Trailer>>() {
            @Override
            public void onChanged(List<Trailer> trailerList) {
                trailersAdapter.setTrailerList(trailerList);
            }
        });

        trailersAdapter.setOnTrailerClickListener(new TrailersAdapter.OnTrailerClickListener() {
            @Override
            public void onTrailerClick(Trailer trailer) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(trailer.getUrl()));
                startActivity(intent);
            }
        });

        movieDetailViewModel.loadReviews(movie.getId());
        movieDetailViewModel.getReviews().observe(this, new Observer<List<Review>>() {
            @Override
            public void onChanged(List<Review> reviews) {
                reviewsAdapter.setReviewList(reviews);
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