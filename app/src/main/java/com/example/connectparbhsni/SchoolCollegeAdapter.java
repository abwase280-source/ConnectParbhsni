package com.example.connectparbhsni;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

public class SchoolCollegeAdapter extends RecyclerView.Adapter<SchoolCollegeAdapter.ViewHolder> {

    private List<SchoolCollegeModel> list;
    private final Context context;
    private Location userLocation;

    public SchoolCollegeAdapter(List<SchoolCollegeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void updateList(List<SchoolCollegeModel> newList) {
        this.list = newList;
        notifyDataSetChanged();
    }

    public void setUserLocation(Location location) {
        this.userLocation = location;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_school_college, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SchoolCollegeModel model = list.get(position);
        holder.tvName.setText(model.getName());
        holder.tvAddress.setText(model.getAddress());
        holder.tvTypeBadge.setText(model.getType());
        holder.tvDescription.setText(model.getDescription());
        holder.tvContact.setText(model.getContact() != null ? model.getContact() : "N/A");
        holder.tvWebsite.setText(model.getWebsite() != null ? model.getWebsite() : "N/A");
        holder.tvEstablished.setText(model.getEstablishedYear() != null ? model.getEstablishedYear() : "N/A");

        if (model.isVerified()) {
            holder.ivVerified.setVisibility(View.VISIBLE);
            holder.tvVerifiedText.setVisibility(View.VISIBLE);
        } else {
            holder.ivVerified.setVisibility(View.GONE);
            holder.tvVerifiedText.setVisibility(View.GONE);
        }

        holder.layoutExpanded.setVisibility(model.isExpanded() ? View.VISIBLE : View.GONE);
        holder.ivExpandArrow.setRotation(model.isExpanded() ? 90f : -90f);

        holder.layoutHeader.setOnClickListener(v -> {
            boolean expanded = model.isExpanded();
            model.setExpanded(!expanded);
            
            TransitionManager.beginDelayedTransition((ViewGroup) holder.itemView.getParent(), new AutoTransition());
            notifyItemChanged(position);
        });

        holder.btnDirections.setOnClickListener(v -> {
            String query = model.getName() + " Parbhani";
            String uri = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(query);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            } else {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvTypeBadge, tvDescription, tvContact, tvWebsite, tvEstablished, tvVerifiedText;
        ImageView ivVerified, ivExpandArrow;
        LinearLayout layoutHeader, layoutExpanded;
        MaterialButton btnDirections;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvTypeBadge = itemView.findViewById(R.id.tvTypeBadge);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvContact = itemView.findViewById(R.id.tvContact);
            tvWebsite = itemView.findViewById(R.id.tvWebsite);
            tvEstablished = itemView.findViewById(R.id.tvEstablished);
            tvVerifiedText = itemView.findViewById(R.id.tvVerifiedText);
            ivVerified = itemView.findViewById(R.id.ivVerified);
            ivExpandArrow = itemView.findViewById(R.id.ivExpandArrow);
            layoutHeader = itemView.findViewById(R.id.layoutHeader);
            layoutExpanded = itemView.findViewById(R.id.layoutExpanded);
            btnDirections = itemView.findViewById(R.id.btnDirections);
        }
    }
}
