package com.example.connectparbhsni;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private List<PlaceModel> places;
    private final Context context;

    public PlaceAdapter(List<PlaceModel> places, Context context) {
        this.places = new ArrayList<>(places);
        this.context = context;
    }

    public void updateList(List<PlaceModel> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new PlaceDiffCallback(this.places, newList));
        this.places.clear();
        this.places.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nearby_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlaceModel place = places.get(position);
        holder.bind(place, context);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCategory, tvAddress, tvHours, tvDistance;
        MaterialButton btnMaps, btnCall;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvPlaceName);
            tvCategory = itemView.findViewById(R.id.tvCategoryBadge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvHours = itemView.findViewById(R.id.tvHours);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            btnMaps = itemView.findViewById(R.id.btnMaps);
            btnCall = itemView.findViewById(R.id.btnCall);
        }

        public void bind(PlaceModel place, Context context) {
            tvName.setText(place.getName());
            tvCategory.setText(place.getCategory());
            tvAddress.setText(place.getAddress());
            tvHours.setText(place.getHours());
            tvDistance.setText(place.getDistance());

            if (place.getPhoneNumber() == null || place.getPhoneNumber().isEmpty() || place.getPhoneNumber().equals("N/A")) {
                btnCall.setVisibility(View.GONE);
            } else {
                btnCall.setVisibility(View.VISIBLE);
                btnCall.setOnClickListener(v -> {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + place.getPhoneNumber()));
                    context.startActivity(intent);
                });
            }

            btnMaps.setOnClickListener(v -> {
                // Using Google Maps search query instead of coordinates for better accuracy
                String query = place.getName() + ", " + place.getAddress();
                String uriString = "geo:0,0?q=" + Uri.encode(query);
                Uri gmmIntentUri = Uri.parse(uriString);
                
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                
                if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(mapIntent);
                } else {
                    // Fallback to web browser or generic view
                    context.startActivity(new Intent(Intent.ACTION_VIEW, gmmIntentUri));
                }
            });
        }
    }

    private static class PlaceDiffCallback extends DiffUtil.Callback {
        private final List<PlaceModel> oldList;
        private final List<PlaceModel> newList;

        public PlaceDiffCallback(List<PlaceModel> oldList, List<PlaceModel> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() { return oldList.size(); }

        @Override
        public int getNewListSize() { return newList.size(); }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName());
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            PlaceModel oldPlace = oldList.get(oldItemPosition);
            PlaceModel newPlace = newList.get(newItemPosition);
            return oldPlace.getAddress().equals(newPlace.getAddress()) &&
                   oldPlace.getDistance().equals(newPlace.getDistance()) &&
                   oldPlace.getHours().equals(newPlace.getHours());
        }
    }
}