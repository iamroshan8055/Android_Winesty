package com.example.roshantirthyash_groupproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {

    EditText txt_HolderName;
    String name;
    TextView Check_Dish, Check_Quantity, Check_Amount, Check_Tax, Check_Total;
    ImageView Check_Image;
    Button btnOrder;
    RadioGroup Radio_Pay;
    EditText creditHolder, creditNumber, creditExpiry, creditCVV, creditPhone;
    TextView txt_Credit;
    CardView card_Credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();

        Check_Image = findViewById(R.id.check_img);
        Check_Dish = findViewById(R.id.check_dish);
        Check_Quantity = findViewById(R.id.check_quantity);
        Check_Amount = findViewById(R.id.check_amount);
        Check_Tax = findViewById(R.id.check_tax);
        Check_Total = findViewById(R.id.check_total);

        String title = intent.getStringExtra("title");
        Integer image = intent.getIntExtra("image",-1);
        int price = intent.getIntExtra("price", 0);
        int quantity = intent.getIntExtra("quantity", 0);

        Check_Dish.setText(title);
        Check_Image.setImageResource(image);
        Check_Quantity.setText(""+quantity);
        Check_Amount.setText("$"+price);
        Check_Tax.setText("$0");
        Check_Total.setText("$"+price);

        Radio_Pay = findViewById(R.id.radioGroup);
        txt_Credit = findViewById(R.id.crd_dtl);
        card_Credit = findViewById(R.id.cardCredit);
        creditHolder=findViewById(R.id.credit_HolderName);
        creditNumber=findViewById(R.id.credit_Number);
        creditExpiry=findViewById(R.id.credit_Expiry);
        creditCVV=findViewById(R.id.credit_CVV);
        creditPhone=findViewById(R.id.credit_Phone);

        Radio_Pay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioBtnCreditDebit)
                {
                    txt_Credit.setVisibility(View.VISIBLE);
                    card_Credit.setVisibility(View.VISIBLE);
                    creditHolder.setVisibility(View.VISIBLE);
                    creditNumber.setVisibility(View.VISIBLE);
                    creditExpiry.setVisibility(View.VISIBLE);
                    creditCVV.setVisibility(View.VISIBLE);
                    creditPhone.setVisibility(View.VISIBLE);
                }
                else {
                    txt_Credit.setVisibility(View.INVISIBLE);
                    card_Credit.setVisibility(View.INVISIBLE);
                    creditHolder.setVisibility(View.INVISIBLE);
                    creditNumber.setVisibility(View.INVISIBLE);
                    creditExpiry.setVisibility(View.INVISIBLE);
                    creditCVV.setVisibility(View.INVISIBLE);
                    creditPhone.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnOrder = findViewById(R.id.btn_order);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                name = creditHolder.getText().toString();

                Intent myIntent = new Intent(Checkout.this, OrderPlaced.class);
                myIntent.putExtra("NAME", name);
                Toast.makeText(Checkout.this, "Order Placed!", Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
            }
        });


    }
}