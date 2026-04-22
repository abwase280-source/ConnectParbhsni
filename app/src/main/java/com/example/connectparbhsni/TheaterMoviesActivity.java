package com.example.connectparbhsni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.Map;

public class TheaterMoviesActivity extends AppCompatActivity {

    private RecyclerView rvMovies;
    private MovieAdapter adapter;
    private TextView tvTheaterName, tvNoMovies, tvLiveStatus;
    private MaterialButton btnCheckOnline;
    private TheaterModel theater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_movies);

        if (getIntent() != null && getIntent().hasExtra("theater")) {
            theater = (TheaterModel) getIntent().getSerializableExtra("theater");
        }

        initViews();
        setupRecyclerView();
    }

    private void initViews() {
        rvMovies = findViewById(R.id.rvMovies);
        tvTheaterName = findViewById(R.id.tvTheaterNameTitle);
        tvNoMovies = findViewById(R.id.tvNoMovies);
        tvLiveStatus = findViewById(R.id.tvLiveStatus);
        btnCheckOnline = findViewById(R.id.btnCheckOnline);
        
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        if (theater != null && theater.getName() != null) {
            tvTheaterName.setText(theater.getName());
            
            btnCheckOnline.setOnClickListener(v -> {
                String query = theater.getName() + " Parbhani movies today";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + query));
                startActivity(intent);
            });
        } else {
            tvTheaterName.setText("Theaters");
            btnCheckOnline.setVisibility(View.GONE);
        }

        // Auto Update Feel: Simulation of "Updated Today"
        tvLiveStatus.setText("Now Showing (Updated Today)");
    }

    private void setupRecyclerView() {
        if (theater != null && theater.getName() != null) {
            Map<String, List<MovieModel>> moviesMap = TheaterDataProvider.getMoviesByTheater(this);
            List<MovieModel> movies = moviesMap.get(theater.getName());

            if (movies != null && !movies.isEmpty()) {
                adapter = new MovieAdapter(this, movies, theater.getName());
                // Set horizontal layout manager for Netflix-style scrolling
                rvMovies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                rvMovies.setAdapter(adapter);
                rvMovies.setNestedScrollingEnabled(false);

                tvNoMovies.setVisibility(View.GONE);
                rvMovies.setVisibility(View.VISIBLE);
                tvLiveStatus.setVisibility(View.VISIBLE);
            } else {
                tvNoMovies.setVisibility(View.VISIBLE);
                rvMovies.setVisibility(View.GONE);
                tvLiveStatus.setVisibility(View.GONE);
                btnCheckOnline.setVisibility(View.GONE);
            }
        }
    }
}
