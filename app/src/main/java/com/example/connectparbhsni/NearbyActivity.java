package com.example.connectparbhsni;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NearbyActivity extends AppCompatActivity {

    private RecyclerView rvNearbyPlaces;
    private PlaceAdapter adapter;
    private EditText etSearch;
    private ProgressBar progressBar;
    private TextView tvNoResults;
    private TabLayout tabLayout;

    private List<PlaceModel> allPlaces;
    private final List<PlaceModel> displayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        rvNearbyPlaces = findViewById(R.id.rvNearbyPlaces);
        progressBar = findViewById(R.id.progressBar);
        tvNoResults = findViewById(R.id.tvNoResults);
        tabLayout = findViewById(R.id.tabLayout);
        etSearch = findViewById(R.id.etSearch);

        rvNearbyPlaces.setHasFixedSize(true);
        rvNearbyPlaces.setLayoutManager(new LinearLayoutManager(this));
        
        allPlaces = NearbyDataProvider.getPlaces().stream()
                .filter(p -> !p.getCategory().equals("HOTEL"))
                .collect(Collectors.toList());
        displayList.addAll(allPlaces);

        adapter = new PlaceAdapter(displayList, this);
        rvNearbyPlaces.setAdapter(adapter);

        setupTabs();
        setupSearch();
        
        filterPlaces();

        findViewById(R.id.appBarBackground).setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

    private void setupTabs() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                filterPlaces();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterPlaces();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterPlaces() {
        int tabIndex = tabLayout.getSelectedTabPosition();
        String query = etSearch.getText().toString().toLowerCase().trim();

        List<PlaceModel> filtered = allPlaces.stream()
                .filter(p -> {
                    boolean categoryMatch = isCategoryMatch(p.getCategory(), tabIndex);
                    boolean queryMatch = query.isEmpty() || p.getName().toLowerCase().contains(query);
                    return categoryMatch && queryMatch;
                })
                .collect(Collectors.toList());

        updateUI(filtered);
    }

    private boolean isCategoryMatch(String placeCategory, int tabIndex) {
        if (tabIndex == 0) return true;
        switch (tabIndex) {
            case 1: return placeCategory.equals("HOSPITAL");
            case 2: return placeCategory.equals("ATM");
            case 3: return placeCategory.equals("BANK");
            case 4: return placeCategory.equals("POLICE");
            case 5: return placeCategory.equals("PETROL");
            default: return false;
        }
    }

    private void updateUI(List<PlaceModel> newList) {
        adapter.updateList(newList);
        tvNoResults.setVisibility(newList.isEmpty() ? View.VISIBLE : View.GONE);
        rvNearbyPlaces.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
