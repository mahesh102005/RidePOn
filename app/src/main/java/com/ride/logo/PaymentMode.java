package com.ride.logo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

;

public class PaymentMode extends AppCompatActivity {

    private RadioButton rbOnline, rbOffline;
    private Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentmode);

        rbOnline = findViewById(R.id.rb_online);
        rbOffline = findViewById(R.id.rb_offline);
        btnPay = findViewById(R.id.btn_pay);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbOnline.isChecked()) {
                    Toast.makeText(PaymentMode.this, "Online Payment Selected", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(PaymentMode.this, onlinepayment.class);
                    startActivity(intent);
                    finish();
                    // Proceed with online payment flow
                } else if (rbOffline.isChecked()) {
                    Toast.makeText(PaymentMode.this, "Cash Payment Selected", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(PaymentMode.this,offlinepayment.class);
                    startActivity(intent);
                    finish();
                    // Proceed with offline payment flow
                } else {
                    Toast.makeText(PaymentMode.this, "Please select a payment method", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
