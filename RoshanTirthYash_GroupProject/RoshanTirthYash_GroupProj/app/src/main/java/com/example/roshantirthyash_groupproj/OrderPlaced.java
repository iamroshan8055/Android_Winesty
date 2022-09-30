package com.example.roshantirthyash_groupproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class OrderPlaced extends AppCompatActivity {

    private static int Start_Screen = 3000;

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);

        display = findViewById(R.id.txt_HolderDisplay);
        Intent myIntent = getIntent();
        String name = myIntent.getStringExtra("NAME");

        display.setText(name);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer(2 seconds) is over and it wiill redirect to main activity
                Intent i = new Intent(OrderPlaced.this, MainActivity.class);
                startActivity(i);
            }
        }, Start_Screen);

    }
}