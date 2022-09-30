package com.example.roshantirthyash_groupproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Champagne extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public ArrayList<products> wineList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        products fd1=new products();
        fd1.setWine_name("Freixenet");
        fd1.setWine_image(R.drawable.champagne_1);
        fd1.setWine_star(4.4f);
        fd1.setWine_price(20);
        fd1.setWine_description(new String[]{"A hardy grape varietal, the Mertol wine grape produces a variety of flavors depending on where it's grown."});
        fd1.setWine_quantity(1);
        fd1.setWine_regions("Australia");
        fd1.setWine_volume("750 ML");
        fd1.setWine_sweetness("Dry");
        fd1.setWine_color("Red brown");
        fd1.setWine_year(1943);

        products fd2=new products();
        fd2.setWine_name("Moet");
        fd2.setWine_image(R.drawable.champagne_5);
        fd2.setWine_star(4f);
        fd2.setWine_price(12);
        fd2.setWine_description(new String[]{"A hardy grape varietal, the Mertol wine grape produces a variety of flavors depending on where it's grown."});
        fd2.setWine_quantity(1);
        fd2.setWine_regions("Australia");
        fd2.setWine_volume("750 ML");
        fd2.setWine_sweetness("Dry");
        fd2.setWine_color("Dark red");
        fd2.setWine_year(1934);

        products fd3=new products();
        fd3.setWine_name("Freixenet");
        fd3.setWine_image(R.drawable.champagne_15);
        fd3.setWine_star(5f);
        fd3.setWine_price(8);
        fd3.setWine_description(new String[]{"A hardy grape varietal, the Mertol wine grape produces a variety of flavors depending on where it's grown."});
        fd3.setWine_quantity(1);
        fd3.setWine_regions("Australia");
        fd3.setWine_volume("750 ML");
        fd3.setWine_sweetness("Dry");
        fd3.setWine_color("Red brown");
        fd3.setWine_year(1964);

        products fd4=new products();
        fd4.setWine_name("Bridesmaid");
        fd4.setWine_image(R.drawable.red_wine_9);
        fd4.setWine_star(4.8f);
        fd4.setWine_price(20);
        fd4.setWine_description(new String[]{"A hardy grape varietal, the Mertol wine grape produces a variety of flavors depending on where it's grown."});
        fd4.setWine_quantity(1);
        fd4.setWine_regions("Australia");
        fd4.setWine_volume("750 ML");
        fd4.setWine_sweetness("Dry");
        fd4.setWine_color("Dark red");
        fd4.setWine_year(1967);

        products fd5=new products();
        fd5.setWine_name("Moet");
        fd5.setWine_image(R.drawable.champagne_6);
        fd5.setWine_star(4.2f);
        fd5.setWine_price(15);
        fd5.setWine_description(new String[]{"A hardy grape varietal, the Mertol wine grape produces a variety of flavors depending on where it's grown."});
        fd5.setWine_quantity(1);
        fd5.setWine_regions("Australia");
        fd5.setWine_volume("750 ML");
        fd5.setWine_sweetness("Dry");
        fd5.setWine_color("Red brown");
        fd5.setWine_year(1986);


        wineList.add(fd1);
        wineList.add(fd2);
        wineList.add(fd3);
        wineList.add(fd4);
        wineList.add(fd5);

        recyclerView = findViewById(R.id.rView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(wineList);
        recyclerView.setAdapter(mAdapter);

    }
}