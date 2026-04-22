package com.example.connectparbhsni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BusRouteDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_route_details);

        String from = getIntent().getStringExtra("BUS_FROM");
        String to = getIntent().getStringExtra("BUS_TO");
        String timing = getIntent().getStringExtra("BUS_TIMING");

        if (from == null) from = "Parbhani";
        if (to == null) to = "Destination";

        TextView tvTitle = findViewById(R.id.tvRouteTitle);
        tvTitle.setText(from + " → " + to);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        RecyclerView rvTimeline = findViewById(R.id.rvTimeline);
        rvTimeline.setLayoutManager(new LinearLayoutManager(this));

        List<StopInfo> stops = getRouteStops(from, to, timing);
        rvTimeline.setAdapter(new TimelineAdapter(stops));
    }

    private List<StopInfo> getRouteStops(String from, String to, String startTime) {
        List<StopInfo> stops = new ArrayList<>();
        List<String> stopNames = new ArrayList<>();

        String destination = to.toLowerCase();

        if (destination.contains("kolhapur")) {
            stopNames.add("Parbhani");
            stopNames.add("Pathri");
            stopNames.add("Manwath");
            stopNames.add("Jalna");
            stopNames.add("Badnapur");
            stopNames.add("Chhatrapati Sambhajinagar");
            stopNames.add("Vaijapur");
            stopNames.add("Shirdi");
            stopNames.add("Ahmednagar");
            stopNames.add("Shirur");
            stopNames.add("Pune");
            stopNames.add("Satara");
            stopNames.add("Karad");
            stopNames.add("Kolhapur");
        } else if (destination.contains("sevagaon pune") || (destination.contains("pune") && !destination.contains("kolhapur"))) {
            stopNames.add("Parbhani");
            stopNames.add("Jintur");
            stopNames.add("Selu");
            stopNames.add("Jalna");
            stopNames.add("Badnapur");
            stopNames.add("Chhatrapati Sambhajinagar");
            stopNames.add("Ahmednagar");
            stopNames.add("Shirur");
            stopNames.add("Pune");
        } else if (destination.contains("sambhajinagar") || destination.contains("aurangabad")) {
            stopNames.add("Parbhani");
            stopNames.add("Pathri");
            stopNames.add("Manwath");
            stopNames.add("Jalna");
            stopNames.add("Badnapur");
            stopNames.add("Chhatrapati Sambhajinagar");
        } else if (destination.contains("amravati") && destination.contains("nagpur")) {
            stopNames.add("Parbhani");
            stopNames.add("Pathri");
            stopNames.add("Jalna");
            stopNames.add("Badnapur");
            stopNames.add("Chhatrapati Sambhajinagar");
            stopNames.add("Sillod");
            stopNames.add("Ajanta");
            stopNames.add("Jalgaon Jamod");
            stopNames.add("Amravati");
            stopNames.add("Wardha");
            stopNames.add("Nagpur");
        } else if (destination.contains("amravati")) {
            stopNames.add("Parbhani");
            stopNames.add("Jintur");
            stopNames.add("Bori");
            stopNames.add("Selu");
            stopNames.add("Washim");
            stopNames.add("Malegaon (Washim)");
            stopNames.add("Akola");
            stopNames.add("Murtizapur");
            stopNames.add("Amravati");
        } else if (destination.contains("buldhana")) {
            stopNames.add("Parbhani");
            stopNames.add("Jintur");
            stopNames.add("Selu");
            stopNames.add("Washim");
            stopNames.add("Malegaon (Washim)");
            stopNames.add("Khamgaon");
            stopNames.add("Buldhana");
        } else if (destination.contains("chandrapur")) {
            stopNames.add("Parbhani");
            stopNames.add("Jintur");
            stopNames.add("Hingoli");
            stopNames.add("Kalamnuri");
            stopNames.add("Washim");
            stopNames.add("Akola");
            stopNames.add("Yavatmal");
            stopNames.add("Wani");
            stopNames.add("Chandrapur");
        } else if (destination.contains("akola")) {
            stopNames.add("Parbhani");
            stopNames.add("Jintur");
            stopNames.add("Selu");
            stopNames.add("Washim");
            stopNames.add("Malegaon (Washim)");
            stopNames.add("Akola");
        } else if (destination.contains("nagpur")) {
            stopNames.add("Parbhani");
            stopNames.add("Pathri");
            stopNames.add("Jalna");
            stopNames.add("Badnapur");
            stopNames.add("Chhatrapati Sambhajinagar");
            stopNames.add("Sillod");
            stopNames.add("Ajanta");
            stopNames.add("Jalgaon Jamod");
            stopNames.add("Amravati");
            stopNames.add("Wardha");
            stopNames.add("Nagpur");
        } else if (destination.contains("beed")) {
            stopNames.add("Parbhani");
            stopNames.add("Pathri");
            stopNames.add("Majalgaon");
            stopNames.add("Georai");
            stopNames.add("Beed");
        } else if (destination.contains("latur")) {
            stopNames.add("Parbhani");
            stopNames.add("Gangakhed");
            stopNames.add("Chakur");
            stopNames.add("Latur");
        } else if (destination.contains("rampur") && destination.contains("nanded")) {
            stopNames.add("Parbhani");
            stopNames.add("Purna");
            stopNames.add("Nanded");
            stopNames.add("Rampur");
        } else if (destination.contains("jintur") && destination.contains("nanded")) {
            stopNames.add("Parbhani");
            stopNames.add("Jintur");
            stopNames.add("Bori");
            stopNames.add("Purna");
            stopNames.add("Nanded");
        } else if (destination.contains("hingoli")) {
            stopNames.add("Parbhani");
            stopNames.add("Jintur");
            stopNames.add("Aundha Nagnath");
            stopNames.add("Hingoli");
        } else if (destination.contains("solapur")) {
            stopNames.add("Parbhani");
            stopNames.add("Gangakhed");
            stopNames.add("Parli");
            stopNames.add("Ambajogai");
            stopNames.add("Latur");
            stopNames.add("Solapur");
        } else if (destination.contains("palam")) {
            stopNames.add("Parbhani");
            stopNames.add("Purna");
            stopNames.add("Palam");
        } else {
            // Default fallback
            stopNames.add(from);
            stopNames.add(to);
        }

        for (int i = 0; i < stopNames.size(); i++) {
            String time = (i == 0) ? startTime : "--:--";
            String distance = (i == 0) ? "0 km" : (i * 25) + " km"; // Placeholder distance
            stops.add(new StopInfo(time, stopNames.get(i), distance));
        }

        return stops;
    }

    private static class StopInfo {
        String time, name, distance;
        StopInfo(String time, String name, String distance) {
            this.time = time;
            this.name = name;
            this.distance = distance;
        }
    }

    private static class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {
        private final List<StopInfo> stops;

        TimelineAdapter(List<StopInfo> stops) {
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
            StopInfo stop = stops.get(position);
            holder.tvTime.setText(stop.time);
            holder.tvStopName.setText(stop.name);
            holder.tvDistance.setText(stop.distance);
            holder.viewLine.setVisibility(position == stops.size() - 1 ? View.INVISIBLE : View.VISIBLE);
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