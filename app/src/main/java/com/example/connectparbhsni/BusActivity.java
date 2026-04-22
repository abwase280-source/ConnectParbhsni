package com.example.connectparbhsni;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class BusActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        autoCompleteTo = findViewById(R.id.autoCompleteTo);
        MaterialButton btnSearch = findViewById(R.id.btnSearchBuses);

        String[] cities = {"Nanded", "Aurangabad", "Pune", "Mumbai", "Nagpur", "Latur", "Jalna"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cities);
        autoCompleteTo.setAdapter(adapter);

        autoCompleteTo.setOnClickListener(v -> autoCompleteTo.showDropDown());

        btnSearch.setOnClickListener(v -> {
            String destination = autoCompleteTo.getText().toString();
            if (destination.isEmpty()) {
                Toast.makeText(this, "Please select a destination", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, BusResultsActivity.class);
                intent.putExtra("FROM_LOCATION", "Parbhani");
                intent.putExtra("TO_LOCATION", destination);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        findViewById(R.id.appBarBackground).setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}
