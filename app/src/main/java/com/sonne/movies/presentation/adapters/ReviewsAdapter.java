package com.sonne.movies.presentation.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sonne.movies.R;
import com.sonne.movies.data.models.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder> {

    private static final String TYPE_POSITIVE = "Позитивный";
    private static final String TYPE_NEGATIVE = "Негативный";

    private List<Review> reviewList = new ArrayList<>();

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_review,
                parent,
                false
        );

        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviewList.get(position);
        holder.tvAuthor.setText(review.getAuthor());
        holder.tvReview.setText(review.getReview());
        String reviewType = review.getType();
        int backgroundId;
        if (reviewType.equals(TYPE_POSITIVE)) {
            backgroundId = R.color.green;
        } else if (reviewType.equals(TYPE_NEGATIVE)) {
            backgroundId = R.color.red;
        } else {
            backgroundId = R.color.orange;
        }
        Drawable background = ContextCompat.getDrawable(holder.itemView.getContext(), backgroundId);
        holder.llReview.setBackground(background);
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvAuthor;
        private final TextView tvReview;
        private final LinearLayout llReview;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAuthor = itemView.findViewById(R.id.textViewAuthor);
            tvReview = itemView.findViewById(R.id.textViewReview);
            llReview = itemView.findViewById(R.id.llReview);
        }
    }
}