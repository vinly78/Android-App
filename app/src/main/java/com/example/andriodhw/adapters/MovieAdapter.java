package com.example.andriodhw.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andriodhw.R;
import com.example.andriodhw.databinding.ItemMovieBinding;
import com.example.andriodhw.models.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final List<MovieModel> movieList;

    public MovieAdapter(List<MovieModel> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding = ItemMovieBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList != null ? movieList.size() : 0;
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private final ItemMovieBinding binding;

        public MovieViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieModel movie) {
            binding.tvTitle.setText(movie.getTitle());
            binding.tvRating.setText(String.valueOf(movie.getRating()));
            binding.tvYear.setText(String.valueOf(movie.getYear()));
            binding.tvDuration.setText(movie.getDuration() + " Minutes");
            binding.tvAgeRating.setText(movie.getAgeRating());
            binding.tvGenre.setText(movie.getGenre());
            binding.tvType.setText("Movie");
            binding.ivPoster.setImageResource(movie.getImageResId());

            // Handle Premium vs Free Badge
            binding.tvAccessType.setText(movie.getType());
            if ("Premium".equalsIgnoreCase(movie.getType())) {
                binding.tvAccessType.setBackgroundResource(R.drawable.bg_premium_badge);
            } else {
                binding.tvAccessType.setBackgroundResource(R.drawable.bg_free_badge);
            }
        }
    }
}