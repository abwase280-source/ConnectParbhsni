package com.example.connectparbhsni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvClock, tvDate;
    private long lastClickTime = 0;
    private final Handler handler = new Handler();
    private List<QuickAccessItem> quickAccessItems;
    private final Runnable updateTimeRunnable = new Runnable() {
        @Override
        public void run() {
            updateTime();
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClock = findViewById(R.id.tvClock);
        tvDate = findViewById(R.id.tvDate);
        RecyclerView rvQuickAccess = findViewById(R.id.rvQuickAccess);

        handler.post(updateTimeRunnable);

        if (quickAccessItems == null) {
            quickAccessItems = new ArrayList<>();
            quickAccessItems.add(new QuickAccessItem("Bus Routes", "Find city bus timings", R.drawable.ic_bus, R.color.bus_icon, R.color.bus_bg));
            quickAccessItems.add(new QuickAccessItem("Train Schedule", "Check train arrivals", R.drawable.ic_train, R.color.train_icon, R.color.train_bg));
            quickAccessItems.add(new QuickAccessItem("Hotels & Restaurants", "Dine and stay", R.drawable.ic_restaurant, R.color.nearby_icon, R.color.nearby_bg));
            quickAccessItems.add(new QuickAccessItem("Nearby Places", "Find local amenities", R.drawable.ic_nearby, R.color.nearby_icon, R.color.nearby_bg));
            quickAccessItems.add(new QuickAccessItem("Tourist Places", "Visit famous spots", R.drawable.ic_tourist, R.color.tourist_icon, R.color.tourist_bg));
            quickAccessItems.add(new QuickAccessItem("Emergency", "Quick help contacts", R.drawable.ic_emergency, R.color.emergency_icon, R.color.emergency_bg));
            quickAccessItems.add(new QuickAccessItem("Theater", "Movies & Cinema Halls", R.drawable.ic_theater, R.color.theater_icon, R.color.theater_bg));
            quickAccessItems.add(new QuickAccessItem("Schools & Colleges", "Educational Institutions", R.drawable.ic_education, R.color.education_icon, R.color.education_bg));
        }

        // Removed rvQuickAccess.setHasFixedSize(true) because height is wrap_content in scrolling direction
        rvQuickAccess.setLayoutManager(new GridLayoutManager(this, 2));
        rvQuickAccess.setAdapter(new QuickAccessAdapter(quickAccessItems, item -> handleNavigation(item.getTitle())));

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setSelectedItemId(R.id.nav_home);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) return true;
            
            String title = "";
            if (id == R.id.nav_buses) title = "Bus Routes";
            else if (id == R.id.nav_trains) title = "Train Schedule";
            else if (id == R.id.nav_auto) title = "Hotels & Restaurants"; 
            else if (id == R.id.nav_nearby) title = "Nearby Places";
            
            if (!title.isEmpty()) {
                handleNavigation(title);
            }
            return false;
        });

        findViewById(R.id.fabEmergency).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:100"));
            startActivity(intent);
        });

        findViewById(R.id.cardAssistance).setOnClickListener(v -> handleNavigation("Emergency"));
    }

    private void handleNavigation(String title) {
        if (SystemClock.elapsedRealtime() - lastClickTime < 500) return;
        lastClickTime = SystemClock.elapsedRealtime();

        Intent intent = null;
        switch (title) {
            case "Bus Routes":
                intent = new Intent(this, BusActivity.class);
                break;
            case "Train Schedule":
                intent = new Intent(this, TrainActivity.class);
                break;
            case "Hotels & Restaurants":
                intent = new Intent(this, HotelActivity.class);
                break;
            case "Nearby Places":
                intent = new Intent(this, NearbyActivity.class);
                break;
            case "Tourist Places":
                intent = new Intent(this, TouristActivity.class);
                break;
            case "Emergency":
                intent = new Intent(this, EmergencyActivity.class);
                break;
            case "Theater":
                intent = new Intent(this, TheaterActivity.class);
                break;
            case "Schools & Colleges":
                intent = new Intent(this, SchoolCollegeActivity.class);
                break;
        }

        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    }

    private void updateTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMM", Locale.getDefault());
        String currentTime = timeFormat.format(new Date());
        String currentDate = dateFormat.format(new Date());
        tvClock.setText(currentTime);
        tvDate.setText(currentDate);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(updateTimeRunnable);
    }
}
