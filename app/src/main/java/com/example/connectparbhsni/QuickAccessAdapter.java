package com.example.connectparbhsni;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuickAccessAdapter extends RecyclerView.Adapter<QuickAccessAdapter.ViewHolder> {

    private final List<QuickAccessItem> items;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(QuickAccessItem item);
    }

    public QuickAccessAdapter(List<QuickAccessItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quick_access, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuickAccessItem item = items.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvDesc.setText(item.getDescription());
        holder.ivIcon.setImageResource(item.getIconRes());
        
        holder.colorStrip.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), item.getIconColorRes()));
        holder.iconContainer.setBackgroundTintList(ContextCompat.getColorStateList(holder.itemView.getContext(), item.getBgColorRes()));
        holder.ivIcon.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), item.getIconColorRes()));

        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc;
        ImageView ivIcon;
        View colorStrip;
        FrameLayout iconContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_title);
            tvDesc = itemView.findViewById(R.id.item_desc);
            ivIcon = itemView.findViewById(R.id.item_icon);
            colorStrip = itemView.findViewById(R.id.color_strip);
            iconContainer = itemView.findViewById(R.id.icon_container);
        }
    }
}
