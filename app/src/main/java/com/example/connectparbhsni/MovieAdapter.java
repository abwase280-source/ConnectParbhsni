package com.example.connectparbhsni;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<MovieModel> movieList;
    private String theaterName;

    public MovieAdapter(Context context, List<MovieModel> movieList, String theaterName) {
        this.context = context;
        this.movieList = movieList;
        this.theaterName = theaterName;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel movie = movieList.get(position);
        holder.tvMovieName.setText(movie.getMovieName());
        holder.tvLanguage.setText(movie.getLanguage());
        holder.tvLastUpdated.setText(movie.getLastUpdated());

        holder.cgShowTimings.removeAllViews();
        for (String timing : movie.getShowTimings()) {
            Chip chip = new Chip(context);
            chip.setText(timing);
            chip.setChipBackgroundColorResource(R.color.bg_light);
            chip.setTextColor(context.getResources().getColor(R.color.black));
            chip.setClickable(false);
            chip.setCheckable(false);
            holder.cgShowTimings.addView(chip);
        }

        holder.btnCheckOnline.setOnClickListener(v -> {
            String query = theaterName + " Parbhani movies today";
            String url = "https://www.google.com/search?q=" + Uri.encode(query);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieName, tvLanguage, tvLastUpdated;
        ChipGroup cgShowTimings;
        MaterialButton btnCheckOnline;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovieName = itemView.findViewById(R.id.tvMovieName);
            tvLanguage = itemView.findViewById(R.id.tvLanguage);
            tvLastUpdated = itemView.findViewById(R.id.tvLastUpdated);
            cgShowTimings = itemView.findViewById(R.id.cgShowTimings);
            btnCheckOnline = itemView.findViewById(R.id.btnCheckOnline);
        }
    }
}
