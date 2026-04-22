package com.example.connectparbhsni;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.TrainViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(TrainModel item);
    }

    private List<TrainModel> trainList;
    private OnItemClickListener listener;

    public TrainAdapter() {
        this.trainList = new ArrayList<>();
    }

    public TrainAdapter(List<TrainModel> trainList, OnItemClickListener listener) {
        this.trainList = trainList;
        this.listener = listener;
    }

    public void setList(List<TrainModel> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new TrainDiffCallback(this.trainList, newList));
        this.trainList = new ArrayList<>(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public TrainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_train, parent, false);
        return new TrainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainViewHolder holder, int position) {
        TrainModel train = trainList.get(position);
        holder.tvTrainNumber.setText(train.getTrainNumber());
        holder.tvTrainName.setText(train.getTrainName());
        holder.tvFromStation.setText(train.getFromStation());
        holder.tvToStation.setText(train.getToStation());
        holder.tvDepartureTime.setText(train.getDepartureTime());
        holder.tvArrivalTime.setText(train.getArrivalTime());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(train);
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, TrainRouteDetailsActivity.class);
                intent.putExtra("TRAIN_NAME", train.getTrainName());
                intent.putStringArrayListExtra("STATION_LIST", new ArrayList<>(train.getStationList()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainList.size();
    }

    static class TrainViewHolder extends RecyclerView.ViewHolder {
        TextView tvTrainNumber, tvTrainName, tvFromStation, tvToStation, tvDepartureTime, tvArrivalTime;

        public TrainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTrainNumber = itemView.findViewById(R.id.tvTrainNumber);
            tvTrainName = itemView.findViewById(R.id.tvTrainName);
            tvFromStation = itemView.findViewById(R.id.tvFromStation);
            tvToStation = itemView.findViewById(R.id.tvToStation);
            tvDepartureTime = itemView.findViewById(R.id.tvDepartureTime);
            tvArrivalTime = itemView.findViewById(R.id.tvArrivalTime);
        }
    }

    private static class TrainDiffCallback extends DiffUtil.Callback {
        private final List<TrainModel> oldList;
        private final List<TrainModel> newList;

        public TrainDiffCallback(List<TrainModel> oldList, List<TrainModel> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() { return oldList.size(); }

        @Override
        public int getNewListSize() { return newList.size(); }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldList.get(oldItemPosition).getTrainNumber().equals(newList.get(newItemPosition).getTrainNumber());
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            TrainModel oldItem = oldList.get(oldItemPosition);
            TrainModel newItem = newList.get(newItemPosition);
            return oldItem.getTrainName().equals(newItem.getTrainName()) &&
                    oldItem.getDepartureTime().equals(newItem.getDepartureTime()) &&
                    oldItem.getArrivalTime().equals(newItem.getArrivalTime());
        }
    }
}
