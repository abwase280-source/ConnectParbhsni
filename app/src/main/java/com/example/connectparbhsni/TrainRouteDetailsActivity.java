package com.example.connectparbhsni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class TrainRouteDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_route_details);

        String trainName = getIntent().getStringExtra("TRAIN_NAME");
        ArrayList<String> stationList = getIntent().getStringArrayListExtra("STATION_LIST");

        TextView tvTitle = findViewById(R.id.tvRouteTitle);
        if (trainName != null) {
            tvTitle.setText(trainName);
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        RecyclerView rvTimeline = findViewById(R.id.rvTimeline);
        rvTimeline.setLayoutManager(new LinearLayoutManager(this));

        if (stationList != null) {
            List<TrainStopInfo> stops = new ArrayList<>();
            for (int i = 0; i < stationList.size(); i++) {
                stops.add(new TrainStopInfo(stationList.get(i), "Stop " + (i + 1)));
            }
            rvTimeline.setAdapter(new TrainTimelineAdapter(stops));
        }
    }

    private static class TrainStopInfo {
        String name, index;
        TrainStopInfo(String name, String index) {
            this.name = name;
            this.index = index;
        }
    }

    private static class TrainTimelineAdapter extends RecyclerView.Adapter<TrainTimelineAdapter.ViewHolder> {
        private final List<TrainStopInfo> stops;

        TrainTimelineAdapter(List<TrainStopInfo> stops) {
            this.stops = stops;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_route_timeline, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            TrainStopInfo stop = stops.get(position);
            holder.tvStopName.setText(stop.name);
            holder.tvDistance.setText(stop.index);
            holder.tvTime.setText("MAPS");
            holder.tvTime.setTextColor(0xFF2563EB); // Blue color for "MAPS"
            holder.viewLine.setVisibility(position == stops.size() - 1 ? View.INVISIBLE : View.VISIBLE);

            holder.itemView.setOnClickListener(v -> {
                String uri = "https://www.google.com/maps/dir/?api=1&destination=" + stop.name + " Railway Station";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                v.getContext().startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return stops.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvTime, tvStopName, tvDistance;
            View viewLine;
            ViewHolder(View itemView) {
                super(itemView);
                tvTime = itemView.findViewById(R.id.tvTime);
                tvStopName = itemView.findViewById(R.id.tvStopName);
                tvDistance = itemView.findViewById(R.id.tvDistance);
                viewLine = itemView.findViewById(R.id.viewLine);
            }
        }
    }
}
