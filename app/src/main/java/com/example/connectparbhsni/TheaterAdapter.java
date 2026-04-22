package com.example.connectparbhsni;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder> {

    private Context context;
    private List<TheaterModel> theaterList;
    private Location userLocation;

    public TheaterAdapter(Context context, List<TheaterModel> theaterList) {
        this.context = context;
        this.theaterList = theaterList;
    }

    public void setUserLocation(Location location) {
        this.userLocation = location;
        notifyDataSetChanged();
    }

    public void updateList(List<TheaterModel> newList) {
        this.theaterList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TheaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_theater, parent, false);
        return new TheaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheaterViewHolder holder, int position) {
        TheaterModel theater = theaterList.get(position);
        holder.tvName.setText(theater.getName());
        holder.tvAddress.setText(theater.getAddress());

        if (userLocation != null) {
            float[] results = new float[1];
            Location.distanceBetween(userLocation.getLatitude(), userLocation.getLongitude(),
                    theater.getLatitude(), theater.getLongitude(), results);
            float distanceInKm = results[0] / 1000;
            holder.tvDistance.setText(String.format(Locale.getDefault(), "📍 %.1f km away", distanceInKm));
            holder.tvDistance.setVisibility(View.VISIBLE);
        } else {
            holder.tvDistance.setVisibility(View.GONE);
        }

        holder.btnViewMovies.setOnClickListener(v -> {
            Intent intent = new Intent(context, TheaterMoviesActivity.class);
            intent.putExtra("theater", theater);
            context.startActivity(intent);
        });

        holder.btnDirections.setOnClickListener(v -> {
            String query = theater.getName() + " Parbhani";
            String uri = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(query);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            } else {
                // Fallback to web browser if Maps is not installed
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return theaterList.size();
    }

    public static class TheaterViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvDistance;
        MaterialButton btnViewMovies, btnDirections;

        public TheaterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvTheaterName);
            tvAddress = itemView.findViewById(R.id.tvTheaterAddress);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            btnViewMovies = itemView.findViewById(R.id.btnViewMovies);
            btnDirections = itemView.findViewById(R.id.btnDirections);
        }
    }
}
