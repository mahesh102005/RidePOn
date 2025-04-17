package com.ride.logo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class driver_home extends AppCompatActivity {

    // Declare view components
    ImageView profileImage, userIcon;
    TextView fareAmount, userName, distanceTime, rating, pickupLabel, pickupLocation;
    LinearLayout fareContainer, requestCard;
    Button acceptButton, rejectButton, nextButton;

    UserDatabaseHelper dbHelper; // Database helper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_home); // Reference to the XML layout file

        // Initialize views
        profileImage = findViewById(R.id.profileImage);
        userIcon = findViewById(R.id.userIcon);
        fareAmount = findViewById(R.id.fareAmount);
        userName = findViewById(R.id.userName);
        distanceTime = findViewById(R.id.distanceTime);
        rating = findViewById(R.id.rating);
        pickupLabel = findViewById(R.id.pickupLabel);
        pickupLocation = findViewById(R.id.pickupLocation);
        fareContainer = findViewById(R.id.fareContainer);
        requestCard = findViewById(R.id.requestCard);
        acceptButton = findViewById(R.id.acceptButton);
        rejectButton = findViewById(R.id.rejectButton);
        nextButton = findViewById(R.id.nextButton);

        dbHelper = new UserDatabaseHelper(this); // Initialize database helper

        // Set data dynamically from the database
        setupUserData();

        // Set button listeners
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(driver_home.this, "Ride Accepted", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(driver_home.this, PaymentMode.class);
            startActivity(intent);
            finish();
            }
        }


        );

        rejectButton.setOnClickListener(v ->
                Toast.makeText(driver_home.this, "Ride Rejected", Toast.LENGTH_SHORT).show()
        );

        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(driver_home.this, next_ride.class);
            startActivity(intent);
        });
    }

    // Function to fetch user name from the database and set it in userName
    private void setupUserData() {
        // Replace this with the actual logged-in user email
        String userEmail = "user@example.com";

        String name = dbHelper.getUserName(userEmail);
        if (name != null) {
            userName.setText(name);
        } else {
            userName.setText("Vaishnavi Chore");
        }

        // You can still set other static example data
        fareAmount.setText("₹ 35.2");
        distanceTime.setText("8 kms away | 12 mins");
        rating.setText("⭐ 4.78");
        pickupLabel.setText("Pickup from");
        pickupLocation.setText("panchawati,amravti,maharashtra");
    }
}