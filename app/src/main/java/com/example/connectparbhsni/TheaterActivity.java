package com.example.connectparbhsni;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

public class TheaterActivity extends AppCompatActivity {

    private RecyclerView rvTheaters;
    private TheaterAdapter adapter;
    private List<TheaterModel> allTheaters;
    private EditText etSearch;
    private FusedLocationProviderClient fusedLocationClient;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        initViews();
        setupRecyclerView();
        setupSearch();
        requestLocation();

        findViewById(R.id.appBarBackground).setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

    private void initViews() {
        rvTheaters = findViewById(R.id.rvTheaters);
        etSearch = findViewById(R.id.etSearchTheater);
    }

    private void setupRecyclerView() {
        allTheaters = TheaterDataProvider.getAllTheaters();
        adapter = new TheaterAdapter(this, allTheaters);
        // Removed rvTheaters.setHasFixedSize(true) because height is 0dp/wrap_content in scrolling direction in some layouts
        rvTheaters.setLayoutManager(new LinearLayoutManager(this));
        rvTheaters.setAdapter(adapter);
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        String query = text.toLowerCase().trim();
        List<TheaterModel> filteredList = new ArrayList<>();
        for (TheaterModel item : allTheaters) {
            if (item.getName().toLowerCase().contains(query) ||
                item.getAddress().toLowerCase().contains(query)) {
                filteredList.add(item);
            }
        }
        adapter.updateList(filteredList);
    }

    private void requestLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            return;
        }

        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                adapter.setUserLocation(location);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestLocation();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
