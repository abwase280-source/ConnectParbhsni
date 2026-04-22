package com.example.connectparbhsni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class TouristDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        // Receive the TouristPlaceModel object from Intent
        TouristPlaceModel place = (TouristPlaceModel) getIntent().getSerializableExtra("place");

        ViewPager2 imageSlider = findViewById(R.id.imageSlider);
        TextView tvPlaceName = findViewById(R.id.tvPlaceName);
        TextView tvFullHistory = findViewById(R.id.tvFullHistory);
        FloatingActionButton fabOpenMap = findViewById(R.id.fabOpenMap);

        if (place != null) {
            Log.d("DEBUG_HISTORY", "Name: " + place.getName());
            
            // Setup Image Slider
            List<Integer> images = place.getImageResIds();
            if (images == null || images.isEmpty()) {
                images = new ArrayList<>();
                images.add(R.drawable.hero_gradient); // Default if no images
            }
            ImageSliderAdapter adapter = new ImageSliderAdapter(images);
            imageSlider.setAdapter(adapter);

            // Bind the full name and full history to the UI
            tvPlaceName.setText(place.getName());
            tvFullHistory.setText(place.getFullHistory());

            fabOpenMap.setOnClickListener(v -> {
                String uri = "geo:" + place.getLatitude() + "," + place.getLongitude() + "?q=" + Uri.encode(place.getName());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            });
        } else {
            Log.e("DEBUG_HISTORY", "TouristPlaceModel is null!");
        }
    }
}
