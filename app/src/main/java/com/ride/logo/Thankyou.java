package com.ride.logo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class Thankyou extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou);

        // Close the activity after 5 seconds
        new Handler().postDelayed(() -> {
            finish(); // Close this activity
            // Optionally, navigate to another activity
            // startActivity(new Intent(ThankYouActivity.this, MainActivity.class));
        }, 5000);
    }
}
