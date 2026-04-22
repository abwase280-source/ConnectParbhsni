package com.example.connectparbhsni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BusResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_results);

        String from = getIntent().getStringExtra("FROM_LOCATION");
        String to = getIntent().getStringExtra("TO_LOCATION");

        TextView tvFromLabel = findViewById(R.id.tvFromLabel);
        TextView tvToLabel = findViewById(R.id.tvToLabel);
        
        if (from != null) tvFromLabel.setText(from);
        if (to != null) tvToLabel.setText(to);

        RecyclerView rvBusResults = findViewById(R.id.rvBusResults);
        rvBusResults.setHasFixedSize(true);
        rvBusResults.setLayoutManager(new LinearLayoutManager(this));

        List<BusModel> busList = getDummyBuses(to);
        
        BusAdapter adapter = new BusAdapter(busList, item -> {
            Intent intent = new Intent(this, BusRouteDetailsActivity.class);
            intent.putExtra("BUS_NAME", item.getBusName());
            startActivity(intent);
        });
        
        rvBusResults.setAdapter(adapter);

        findViewById(R.id.appBarBackground).setOnClickListener(v -> finish());
    }

    private List<BusModel> getDummyBuses(String to) {
        List<BusModel> list = new ArrayList<>();
        list.add(new BusModel("MSRTC Shivshahi", "08:30 AM", "02:30 PM", "6h 00m", "₹450", "AC Seater", to));
        list.add(new BusModel("MSRTC Hirkani", "10:00 AM", "04:30 PM", "6h 30m", "₹380", "Asiad Pan Asia", to));
        list.add(new BusModel("Private Travels (Khurana)", "09:15 PM", "05:00 AM", "7h 45m", "₹650", "Sleeper 2+1", to));
        list.add(new BusModel("MSRTC Ordinary", "06:00 AM", "01:00 PM", "7h 00m", "₹280", "Lal Pari", to));
        return list;
    }
}
