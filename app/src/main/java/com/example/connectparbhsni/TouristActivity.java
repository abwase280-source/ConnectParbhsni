package com.example.connectparbhsni;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TouristActivity extends AppCompatActivity {

    private RecyclerView rvTouristPlaces;
    private TouristAdapter adapter;
    private TabLayout tabLayout;
    private TextView tvNoResults;
    private List<TouristPlaceModel> allPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);

        // Setup UI components
        rvTouristPlaces = findViewById(R.id.rvTouristPlaces);
        tabLayout = findViewById(R.id.tabLayout);
        tvNoResults = findViewById(R.id.tvNoResults);
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        rvTouristPlaces.setLayoutManager(new LinearLayoutManager(this));

        // Get data from provider
        allPlaces = TouristDataProvider.getTouristPlaces();

        // Set adapter
        adapter = new TouristAdapter(new ArrayList<>(allPlaces), this);
        rvTouristPlaces.setAdapter(adapter);

        setupTabs();
    }

    private void setupTabs() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                filterPlaces(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void filterPlaces(int tabIndex) {
        List<TouristPlaceModel> filtered;
        if (tabIndex == 0) {
            filtered = new ArrayList<>(allPlaces);
        } else {
            String targetCategory = getCategoryFromTabIndex(tabIndex);
            filtered = allPlaces.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(targetCategory))
                    .collect(Collectors.toList());
        }

        adapter.updateList(filtered);
        tvNoResults.setVisibility(filtered.isEmpty() ? View.VISIBLE : View.GONE);
    }

    private String getCategoryFromTabIndex(int tabIndex) {
        switch (tabIndex) {
            case 1: return "RELIGIOUS";
            case 2: return "HISTORICAL";
            case 3: return "NATURE_SCENIC";
            case 4: return "EDUCATIONAL_PUBLIC";
            default: return "";
        }
    }
}
