package com.example.connectparbhsni;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TrainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteFrom, autoCompleteTo;
    private EditText etSearchTrain;
    private RecyclerView rvTrains;
    private TrainAdapter adapter;
    private List<TrainModel> allTrains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        autoCompleteFrom = findViewById(R.id.autoCompleteFrom);
        autoCompleteTo = findViewById(R.id.autoCompleteTo);
        etSearchTrain = findViewById(R.id.etSearchTrain);
        ImageButton btnSwap = findViewById(R.id.btnSwap);
        MaterialButton btnSearch = findViewById(R.id.btnSearchTrains);
        rvTrains = findViewById(R.id.rvTrains);

        allTrains = TrainDataProvider.getTrains();

        autoCompleteFrom.setText("Parbhani");
        autoCompleteFrom.setEnabled(false);
        autoCompleteFrom.setFocusable(false);

        setupToStationSuggestions();

        rvTrains.setHasFixedSize(true);
        rvTrains.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TrainAdapter();
        rvTrains.setAdapter(adapter);
        
        rvTrains.setVisibility(View.GONE);

        btnSwap.setOnClickListener(v -> {
            Toast.makeText(this, "Source station is fixed to Parbhani", Toast.LENGTH_SHORT).show();
        });

        btnSearch.setOnClickListener(v -> {
            String destination = autoCompleteTo.getText().toString().trim();
            if (destination.isEmpty()) {
                Toast.makeText(this, "Please select a destination", Toast.LENGTH_SHORT).show();
                return;
            }
            
            Intent intent = new Intent(this, TrainResultsActivity.class);
            intent.putExtra("DESTINATION", destination);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });

        etSearchTrain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().trim();
                if (query.isEmpty()) {
                    rvTrains.setVisibility(View.GONE);
                } else {
                    rvTrains.setVisibility(View.VISIBLE);
                    filterTrainsLocally(query);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        findViewById(R.id.appBarBackground).setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

    private void setupToStationSuggestions() {
        Set<String> allDestinations = allTrains.stream()
                .map(TrainModel::getToStation)
                .collect(Collectors.toSet());

        List<String> sortedDestinations = new ArrayList<>(allDestinations);
        sortedDestinations.sort(String::compareTo);

        ArrayAdapter<String> toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sortedDestinations);
        autoCompleteTo.setAdapter(toAdapter);
        autoCompleteTo.setThreshold(1);
    }

    private void filterTrainsLocally(String query) {
        String lowerQuery = query.toLowerCase();
        List<TrainModel> filtered = allTrains.stream()
                .filter(t -> t.getTrainNumber().contains(lowerQuery) || t.getTrainName().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toList());
        adapter.setList(filtered);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
