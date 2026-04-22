package com.example.connectparbhsni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

public class TheaterDetailActivity extends AppCompatActivity {

    private ImageView ivTheaterImage;
    private TextView tvName, tvDescription, tvAddress, tvContact, tvMultiplexBadge;
    private MaterialButton btnDirections;
    private TheaterModel theater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_detail);

        theater = (TheaterModel) getIntent().getSerializableExtra("theater");

        initViews();
        setupData();
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        ivTheaterImage = findViewById(R.id.ivTheaterDetailImage);
        tvName = findViewById(R.id.tvDetailTheaterName);
        tvDescription = findViewById(R.id.tvTheaterDescription);
        tvAddress = findViewById(R.id.tvDetailTheaterAddress);
        tvContact = findViewById(R.id.tvDetailTheaterContact);
        tvMultiplexBadge = findViewById(R.id.tvMultiplexBadge);
        btnDirections = findViewById(R.id.btnDetailDirections);
    }

    private void setupData() {
        if (theater != null) {
            tvName.setText(theater.getName());
            tvDescription.setText(theater.getDescription());
            tvAddress.setText(theater.getAddress());
            tvContact.setText(theater.getContactNumber());
            ivTheaterImage.setImageResource(theater.getImageResId());

            if (theater.isMultiplex()) {
                tvMultiplexBadge.setVisibility(View.VISIBLE);
            } else {
                tvMultiplexBadge.setVisibility(View.GONE);
            }

            btnDirections.setOnClickListener(v -> {
                String query = theater.getName() + " Parbhani";
                String uri = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(query);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // Fallback to web browser if Maps is not installed
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
                }
            });
        }
    }
}
