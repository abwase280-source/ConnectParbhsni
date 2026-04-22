package com.example.connectparbhsni;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {

    private final List<BusModel> list;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(BusModel item);
    }

    public BusAdapter(List<BusModel> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bus_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BusModel model = list.get(position);
        holder.tvBusName.setText(model.getBusName());
        holder.tvDepartureTime.setText(model.getDepartureTime());
        holder.tvArrivalTime.setText(model.getArrivalTime());
        holder.tvDuration.setText(model.getDuration());
        holder.tvPrice.setText(model.getPrice());
        holder.tvBusType.setText(model.getBusType());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(model));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBusName, tvDepartureTime, tvArrivalTime, tvDuration, tvPrice, tvBusType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBusName = itemView.findViewById(R.id.tvBusName);
            tvDepartureTime = itemView.findViewById(R.id.tvDepartureTime);
            tvArrivalTime = itemView.findViewById(R.id.tvArrivalTime);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvBusType = itemView.findViewById(R.id.tvBusType);
        }
    }
}
