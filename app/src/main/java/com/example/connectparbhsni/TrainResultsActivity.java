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

public class TrainResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_results);

        String from = "Parbhani";
        String to = getIntent().getStringExtra("DESTINATION");

        RecyclerView rvTrains = findViewById(R.id.rvTrainResults);
        rvTrains.setHasFixedSize(true);
        rvTrains.setLayoutManager(new LinearLayoutManager(this));

        List<TrainModel> trainList = TrainDataProvider.getTrainsForRoute(from, to);
        
        TextView tvNoTrains = findViewById(R.id.tvNoTrains);
        if (trainList.isEmpty()) {
            tvNoTrains.setVisibility(View.VISIBLE);
        } else {
            tvNoTrains.setVisibility(View.GONE);
        }

        TrainAdapter adapter = new TrainAdapter(trainList, item -> {
            Intent intent = new Intent(this, TrainRouteDetailsActivity.class);
            intent.putExtra("TRAIN_NUMBER", item.getTrainNumber());
            intent.putExtra("TRAIN_NAME", item.getTrainName());
            intent.putStringArrayListExtra("STATION_LIST", new ArrayList<>(item.getStationList()));
            startActivity(intent);
        });
        
        rvTrains.setAdapter(adapter);

        findViewById(R.id.appBarBackground).setOnClickListener(v -> finish());
    }
}
