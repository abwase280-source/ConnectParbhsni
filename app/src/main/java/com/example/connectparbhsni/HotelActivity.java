package com.example.connectparbhsni;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelActivity extends AppCompatActivity {

    private RecyclerView rvHotels;
    private PlaceAdapter adapter;
    private EditText etSearch;
    private TextView tvNoResults;
    private List<PlaceModel> hotelList;
    private final List<PlaceModel> displayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        rvHotels = findViewById(R.id.rvNearbyPlaces);
        tvNoResults = findViewById(R.id.tvNoResults);
        etSearch = findViewById(R.id.etSearch);
        
        findViewById(R.id.tabLayout).setVisibility(View.GONE);
        
        TextView tvTitle = findViewById(R.id.tvNearbyTitle);
        tvTitle.setText("Hotels & Restaurants");

        rvHotels.setHasFixedSize(true);
        rvHotels.setLayoutManager(new LinearLayoutManager(this));
        
        hotelList = NearbyDataProvider.getHotelPlaces();
        displayList.addAll(hotelList);

        adapter = new PlaceAdapter(displayList, this);
        rvHotels.setAdapter(adapter);

        setupSearch();
        updateUI(displayList);

        findViewById(R.id.appBarBackground).setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterHotels(s.toString().toLowerCase().trim());
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterHotels(String query) {
        List<PlaceModel> filtered = hotelList.stream()
                .filter(p -> query.isEmpty() || p.getName().toLowerCase().contains(query))
                .collect(Collectors.toList());
        updateUI(filtered);
    }

    private void updateUI(List<PlaceModel> newList) {
        adapter.updateList(newList);
        tvNoResults.setVisibility(newList.isEmpty() ? View.VISIBLE : View.GONE);
        rvHotels.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
