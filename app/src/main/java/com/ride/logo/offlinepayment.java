package com.ride.logo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.ride.logo.R;

public class offlinepayment extends AppCompatActivity {

    private EditText etAmount;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offlinepayment);

        etAmount = findViewById(R.id.et_amount);
        btnConfirm = findViewById(R.id.btn_confirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = etAmount.getText().toString().trim();

                if (amount.isEmpty()) {
                    Toast.makeText(offlinepayment.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(offlinepayment.this, "Payment of ₹" + amount + " confirmed!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(offlinepayment.this,paymentDone.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
