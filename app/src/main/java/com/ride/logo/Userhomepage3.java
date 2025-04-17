package com.ride.logo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Userhomepage3 extends AppCompatActivity {

    private TextView travelTime;
    private TextView travelDistance;
    private TextView address;
    private TextView price;
    private Button bookNowButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhomepage3);

        // Initialize Views
        travelTime = findViewById(R.id.travelTime);
        travelDistance = findViewById(R.id.travelDistance);
        address = findViewById(R.id.address);
        price = findViewById(R.id.price);
        bookNowButton = findViewById(R.id.bookNowButton);

        // Retrieve Data from Intent
        Intent intent = getIntent();
        if (intent != null) {
            String pickup = intent.getStringExtra("PICKUP_LOCATION");
            String drop = intent.getStringExtra("DROP_LOCATION");
            int distance = intent.getIntExtra("DISTANCE", 0);
            double time = intent.getDoubleExtra("TIME", 0.0);
            double fare = intent.getDoubleExtra("FARE", 0.0);
            String passengers = intent.getStringExtra("PASSENGERS");

            // Update UI
            address.setText("Pickup: " + pickup + "\nDrop: " + drop);
            travelDistance.setText(distance + " km");
            travelTime.setText(time + " min");
            price.setText("Rs " + fare);
        }

        // Book Now Button Click Listener
        bookNowButton.setOnClickListener(view -> {
            Intent thankYouIntent = new Intent(Userhomepage3.this, Thankyou.class);
            startActivity(thankYouIntent);
            finish();
            Toast.makeText(Userhomepage3.this, "Booking Confirmed!", Toast.LENGTH_SHORT).show();
        });
    }
}

