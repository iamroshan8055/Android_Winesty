package com.example.roshantirthyash_groupproj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView txtTitle, txtDetails, txtPrice, txtRegions, txtVolume, txtSweetness, txtColor, txtYear, txtQuantity;
    Button btnBuy;
    RatingBar ratingBar;
    ImageView images, minusQuantity, plusQuantity;
    int count, price_inc_dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();


        txtTitle = findViewById(R.id.text_name);
        txtDetails = findViewById(R.id.text_desciption);
        ratingBar  = findViewById(R.id.text_rat);
        txtPrice = findViewById(R.id.text_price);
        images = findViewById(R.id.image_1);
        txtRegions = findViewById(R.id.text_regions);
        txtVolume = findViewById(R.id.text_volume);
        txtSweetness = findViewById(R.id.text_sweetness);
        txtColor = findViewById(R.id.text_color);
        txtYear = findViewById(R.id.text_year);
        txtQuantity = findViewById(R.id.text_quantity);
        minusQuantity = findViewById(R.id.quantitiy_minus);
        plusQuantity = findViewById(R.id.quantitiy_plus);

        btnBuy = findViewById(R.id.btn_buy);

        String title = intent.getStringExtra("title");
        Integer image = intent.getIntExtra("image",-1);
        String description[] = intent.getStringArrayExtra("description");
        int quantity = intent.getIntExtra("quantity", 0);
        int price = intent.getIntExtra("price", 0);
        float rating = intent.getFloatExtra("star",-1);
        String regions = intent.getStringExtra("regions");
        String volume = intent.getStringExtra("volume");
        String sweetness = intent.getStringExtra("sweetness");
        String color = intent.getStringExtra("color");
        int year = intent.getIntExtra("year", 0);

        price_inc_dec = price;
        count = quantity;

        plusQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                price_inc_dec = price_inc_dec + price;
                txtQuantity.setText(""+String.valueOf(count));
                txtPrice.setText("$"+String.valueOf(price_inc_dec));
            }
        });

        minusQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if(count <= 1) {
                    count = 1;
                    price_inc_dec = price;
                }
                if(count > 1) {
                    price_inc_dec = price_inc_dec - price;
                }
                txtQuantity.setText(""+String.valueOf(count));
                txtPrice.setText("$"+String.valueOf(price_inc_dec));
            }
        });

        txtTitle.setText(title);
        String detail ="";
        for(int i=0; i<description.length;i++){
            detail = detail + description[i] +"\n\n";
        }
        txtDetails.setText(detail);
        ratingBar.setRating(rating);
        images.setImageResource(image);
        txtPrice.setText("$"+price);
        txtRegions.setText(regions);
        txtVolume.setText(volume);
        txtSweetness.setText(sweetness);
        txtColor.setText(color);
        txtYear.setText(year+"");
        txtQuantity.setText(quantity+"");

        btnBuy.setOnClickListener(new View.OnClickListener() {
            //            @Override
            public void onClick(View v) {
                Log.i("info","------Hello you have clicked Buy button------");

                Intent myIntent = new Intent(Display.this, Checkout.class);
                myIntent.putExtra("image",image);
                myIntent.putExtra("title",title);
                myIntent.putExtra("price", price_inc_dec);
                myIntent.putExtra("quantity", count);
                startActivity(myIntent);
            }
        });

    }
}