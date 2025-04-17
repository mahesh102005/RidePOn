package com.ride.logo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.ride.logo.R;

public class onlinepayment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onlinepayment);

        // Back Button Click
        ImageView backButton = findViewById(R.id.Back_arrow1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(onlinepayment.this,PaymentMode.class);
                startActivity(intent);
                finish();
            }
        });

        // Display Payment Amount
        TextView amountText = findViewById(R.id.amount);
        amountText.setText("$38.45"); // You can change this dynamically

        // Generate QR Code
        ImageView qrImageView = findViewById(R.id.imgqrcode);
        generateQRCode(qrImageView, "https://payment.example.com/38.45");
    }

    private void generateQRCode(ImageView qrImageView, String qrData) {
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, 250, 250);
            qrImageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

}