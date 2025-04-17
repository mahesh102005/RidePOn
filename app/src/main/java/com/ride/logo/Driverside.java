package com.ride.logo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Driverside extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView forgotPasswordText, signUpText;
    private ImageView backArrow; // Declare back arrow

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverside);

        // Initialize views
        emailEditText = findViewById(R.id.email_username1);
        passwordEditText = findViewById(R.id.password1);
        loginButton = findViewById(R.id.login_button1);
        forgotPasswordText = findViewById(R.id.forgot_password1);
        signUpText = findViewById(R.id.NewRegistration1);
        backArrow = findViewById(R.id.Back_arrow1); // Initialize back arrow

        // Back arrow click listener
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(Driverside.this, R.anim.button_click);
                v.startAnimation(animation);
                // Navigate back to the previous activity
                Intent intent = new Intent(Driverside.this, ButtonActivity.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });


        // Login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                Animation animation = AnimationUtils.loadAnimation(Driverside.this, R.anim.button_click);
                v.startAnimation(animation);

                if (validateInputs(email, password)) {
                    // Handle login logic
                    Toast.makeText(Driverside.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    // Redirect to another activity if needed
                    Intent intent=new Intent(Driverside.this,driver_home.class);
                    startActivity(intent);
                }
            }
        });

        // Forgot password click listener
        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Driverside.this, "Forgot Password Clicked!", Toast.LENGTH_SHORT).show();
                // Redirect to Forgot Password Activity if needed
            }
        });

        // Sign up click listener
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
                // Redirect to Sign Up Activity if needed
                Intent intent = new Intent(Driverside.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }

    // Validate inputs
    private boolean validateInputs(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Please enter your email/username");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Please enter your password");
            return false;
        }
        return true;
    }
}