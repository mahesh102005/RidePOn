package com.ride.logo;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Userhomepage1 extends AppCompatActivity {

    private Spinner pickupSpinner, dropSpinner, passengerSpinner;
    private Button calculateButton;
    private Button booklater;
    private ImageView back;

    private final double RATE_PER_KM = 4.40;
    private final double TIME_PER_KM = 1.5;

    private final HashMap<String, Integer> distanceMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhomepage1);

        pickupSpinner = findViewById(R.id.pickupSpinner);
        dropSpinner = findViewById(R.id.dropSpinner);
        passengerSpinner = findViewById(R.id.passengerSpinner);
        calculateButton = findViewById(R.id.calculateButton);
        booklater = findViewById(R.id.booklater);
        back=findViewById(R.id.back1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Userhomepage1.this,Userside.class);
                startActivity(intent);
                finish();
            }
        });

        booklater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Userhomepage1.this, "Thank you for visiting", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Userhomepage1.this, Userside.class);
                startActivity(intent);
                finish();
            }
        });

        // Define Distance Data
        distanceMap.put("Panchawati-Rajkamal", 5);
        distanceMap.put("Panchawati-Rajapeth", 4);
        distanceMap.put("Panchawati-Nevsari", 7);
        distanceMap.put("Panchawati-Dasturnagar", 8);
        distanceMap.put("Panchawati-Badnera", 12);
        distanceMap.put("Panchawati-Sainagar", 10);

        distanceMap.put("Rajkamal-Panchawati", 5);
        distanceMap.put("Rajkamal-Rajapeth", 2);
        distanceMap.put("Rajkamal-Nevsari", 9);
        distanceMap.put("Rajkamal-Dasturnagar", 4);
        distanceMap.put("Rajkamal-Badnera", 11);
        distanceMap.put("Rajkamal-Sainagar", 9);

        distanceMap.put("Rajapeth-Panchawati", 4);
        distanceMap.put("Rajapeth-Rajkamal", 3);
        distanceMap.put("Rajapeth-Nevsari", 5);
        distanceMap.put("Rajapeth-Dasturnagar", 4);
        distanceMap.put("Rajapeth-Badnera", 10);
        distanceMap.put("Rajapeth-Sainagar", 8);

        distanceMap.put("Nevsari-Panchawati", 7);
        distanceMap.put("Nevsari-Rajkamal", 6);
        distanceMap.put("Nevsari-Rajapeth", 5);
        distanceMap.put("Nevsari-Dasturnagar", 3);
        distanceMap.put("Nevsari-Badnera", 8);
        distanceMap.put("Nevsari-Sainagar", 7);

        distanceMap.put("Dasturnagar-Panchawati", 6);
        distanceMap.put("Dasturnagar-Rajkamal", 5);
        distanceMap.put("Dasturnagar-Rajapeth", 4);
        distanceMap.put("Dasturnagar-Nevsari", 3);
        distanceMap.put("Dasturnagar-Badnera", 7);
        distanceMap.put("Dasturnagar-Sainagar", 6);

        distanceMap.put("Badnera-Panchawati", 12);
        distanceMap.put("Badnera-Rajkamal", 11);
        distanceMap.put("Badnera-Rajapeth", 10);
        distanceMap.put("Badnera-Nevsari", 8);
        distanceMap.put("Badnera-Dasturnagar", 7);
        distanceMap.put("Badnera-Sainagar", 5);

        distanceMap.put("Sainagar-Panchawati", 10);
        distanceMap.put("Sainagar-Rajkamal", 9);
        distanceMap.put("Sainagar-Rajapeth", 8);
        distanceMap.put("Sainagar-Nevsari", 7);
        distanceMap.put("Sainagar-Dasturnagar", 6);
        distanceMap.put("Sainagar-Badnera", 5);


        // Setup Spinners
        String[] locations = {"Panchawati", "Rajkamal", "Rajapeth", "Nevsari", "Dasturnagar", "Badnera", "Sainagar"};
        String[] passengers = {"1", "2", "3", "4", "5"};

        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locations);
        pickupSpinner.setAdapter(locationAdapter);
        dropSpinner.setAdapter(locationAdapter);

        ArrayAdapter<String> passengerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, passengers);
        passengerSpinner.setAdapter(passengerAdapter);

        calculateButton.setOnClickListener(v -> calculateFare());
    }

    private void calculateFare() {
        String pickup = pickupSpinner.getSelectedItem().toString();
        String drop = dropSpinner.getSelectedItem().toString();
        String passengers = passengerSpinner.getSelectedItem().toString();

        if (pickup.equals(drop)) {
            Toast.makeText(this, "Pickup and Drop cannot be the same!", Toast.LENGTH_SHORT).show();
            return;
        }

        String key = pickup + "-" + drop;
        Integer distance = distanceMap.get(key);

        if (distance == null) {
            Toast.makeText(this, "Distance data not available!", Toast.LENGTH_SHORT).show();
            return;
        }

        double fare = distance * RATE_PER_KM;
        double time = distance * TIME_PER_KM;

        // Pass pickup, drop, and other details separately
        Intent intent = new Intent(Userhomepage1.this, Userhomepage3.class);
        intent.putExtra("PICKUP_LOCATION", pickup);
        intent.putExtra("DROP_LOCATION", drop);
        intent.putExtra("DISTANCE", distance);
        intent.putExtra("TIME", time);
        intent.putExtra("FARE", fare);
        intent.putExtra("PASSENGERS", passengers);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}

