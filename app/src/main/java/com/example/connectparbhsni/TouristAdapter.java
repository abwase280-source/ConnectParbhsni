package com.example.connectparbhsni;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class TouristAdapter extends RecyclerView.Adapter<TouristAdapter.ViewHolder> {

    private List<TouristPlaceModel> places;
    private final Context context;

    public TouristAdapter(List<TouristPlaceModel> places, Context context) {
        this.places = new ArrayList<>(places);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tourist_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TouristPlaceModel place = places.get(position);
        holder.tvName.setText(place.getName());
        holder.tvDescription.setText(place.getShortDescription());
        holder.tvAddress.setText(place.getLocationName());

        if (place.getImageResIds() != null && !place.getImageResIds().isEmpty()) {
            holder.ivImage.setImageResource(place.getImageResIds().get(0));
        } else {
            // Default image if none provided
            holder.ivImage.setImageResource(R.drawable.hero_gradient);
        }

        // Fix: Pass selectedTouristPlaceModel via intent correctly
        holder.itemView.setOnClickListener(v -> {
            Log.d("DEBUG_SEND", "Full History to send: " + place.getFullHistory());
            Intent intent = new Intent(context, TouristDetailActivity.class);
            intent.putExtra("place", place);
            context.startActivity(intent);
        });

        holder.btnOpenMaps.setOnClickListener(v -> {
            String uri = "geo:" + place.getLatitude() + "," + place.getLongitude() + "?q=" + Uri.encode(place.getName());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public void updateList(List<TouristPlaceModel> newList) {
        this.places = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName, tvDescription, tvAddress;
        MaterialButton btnOpenMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivPlaceImage);
            tvName = itemView.findViewById(R.id.tvPlaceName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            btnOpenMaps = itemView.findViewById(R.id.btnOpenMaps);
        }
    }
}
