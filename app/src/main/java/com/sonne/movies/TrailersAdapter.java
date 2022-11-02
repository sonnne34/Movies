package com.sonne.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailerViewHolder> {

    private List<Trailer> trailerList = new ArrayList<>();
    private OnTrailerClickListener onTrailerClickListener;

    public void setTrailerList(List<Trailer> trailerList) {
        this.trailerList = trailerList;
        notifyDataSetChanged();
    }

    public void setOnTrailerClickListener(OnTrailerClickListener onTrailerClickListener) {
        this.onTrailerClickListener = onTrailerClickListener;
    }

    @NonNull
    @Override
    public TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_trailers,
                parent,
                false
        );
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerViewHolder holder, int position) {
        Trailer trailers = trailerList.get(position);
        holder.buttonTrailer.setText(trailers.getName());
        holder.buttonTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onTrailerClickListener != null){
                    onTrailerClickListener.onTrailerClick(trailers);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return trailerList.size();
    }

    static class TrailerViewHolder extends RecyclerView.ViewHolder {
        private final Button buttonTrailer;

        public TrailerViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonTrailer = itemView.findViewById(R.id.buttonTrailer);
        }
    }

    interface OnTrailerClickListener {
        void onTrailerClick(Trailer trailer);
    }

}
