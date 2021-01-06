package com.enesinky.uberwebapplauncherdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.enesinky.uberwebapplauncher.UberWebAppLauncher;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "uberwebapplauncher";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText pickUpPlaceEditText = findViewById(R.id.pick_up_nick);
        EditText pickUpLatEditText = findViewById(R.id.pickup_lat);
        EditText pickUpLonEditText = findViewById(R.id.pickup_lon);
        EditText dropoffPlaceEditText = findViewById(R.id.dropoff_nick);
        EditText dropoffLatEditText = findViewById(R.id.dropoff_lat);
        EditText dropoffLonEditText = findViewById(R.id.dropoff_lon);
        Button submitBtn = findViewById(R.id.goto_webapp_btn);

        submitBtn.setOnClickListener(v -> {
            double pLat = 0;
            double pLon = 0;
            double dLat = 0;
            double dLon = 0;
            try {
                pLat = Double.parseDouble(pickUpLatEditText.getText().toString());
                pLon = Double.parseDouble(pickUpLonEditText.getText().toString());
                dLat = Double.parseDouble(dropoffLatEditText.getText().toString());
                dLon = Double.parseDouble(dropoffLonEditText.getText().toString());
            }
            catch(NumberFormatException e)
            {
                Log.e(TAG, "onCreate: Parsing Error: Check input coordinates.");
            }

            if(0 != pLat && 0 != pLon && 0 != dLat && 0 != dLon && null != pickUpPlaceEditText.getText().toString() && null != dropoffPlaceEditText.getText().toString()) {

                UberWebAppLauncher uberWebAppLauncher = new UberWebAppLauncher()
                        .setPickupLocation(pLat, pLon, "", pickUpPlaceEditText.getText().toString())
                        .setDropoffLocation(dLat, dLon, "", dropoffPlaceEditText.getText().toString())
                        .build();

                Intent intent = new Intent(Intent.ACTION_VIEW, uberWebAppLauncher.getUri());
                startActivity(intent);

            }
            else {
                Toast.makeText(this, "Please fill input values correctly.", Toast.LENGTH_LONG).show();
            }

        });


    }
}