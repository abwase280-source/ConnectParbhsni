package com.example.connectparbhsni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EmergencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        RecyclerView rvEmergency = findViewById(R.id.rvEmergency);
        rvEmergency.setLayoutManager(new LinearLayoutManager(this));

        List<EmergencyModel> contacts = new ArrayList<>();
        contacts.add(new EmergencyModel("Police", "100"));
        contacts.add(new EmergencyModel("Fire Brigade", "101"));
        contacts.add(new EmergencyModel("Ambulance", "102"));
        contacts.add(new EmergencyModel("Women Helpline", "1091"));
        contacts.add(new EmergencyModel("Child Helpline", "1098"));
        contacts.add(new EmergencyModel("Disaster Management", "108"));
        contacts.add(new EmergencyModel("Railway Helpline", "139"));

        rvEmergency.setAdapter(new EmergencyAdapter(contacts));
    }

    private class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.ViewHolder> {
        private final List<EmergencyModel> contacts;

        EmergencyAdapter(List<EmergencyModel> contacts) {
            this.contacts = contacts;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emergency, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            EmergencyModel contact = contacts.get(position);
            holder.tvName.setText(contact.getTitle());
            holder.tvNumber.setText(contact.getPhoneNumber());
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + contact.getPhoneNumber()));
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return contacts.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvName, tvNumber;
            ViewHolder(View itemView) {
                super(itemView);
                tvName = itemView.findViewById(R.id.tvEmergencyName);
                tvNumber = itemView.findViewById(R.id.tvEmergencyNumber);
            }
        }
    }
}