package com.example.roshantirthyash_groupproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Fragment_Home extends Fragment implements View.OnClickListener {

    public CardView card_Red, card_White, card_Rose, card_Dessert, card_Sparkling, card_Fortified, card_Champagne;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        card_Red = v.findViewById(R.id.wt_card_1);
        card_White = v.findViewById(R.id.wt_card_2);
        card_Rose = v.findViewById(R.id.wt_card_3);
        card_Dessert = v.findViewById(R.id.wt_card_4);
        card_Sparkling = v.findViewById(R.id.wt_card_5);
        card_Fortified = v.findViewById(R.id.wt_card_6);
        card_Champagne = v.findViewById(R.id.wt_card_7);

        card_Red.setOnClickListener(this);
        card_White.setOnClickListener(this);
        card_Rose.setOnClickListener(this);
        card_Dessert.setOnClickListener(this);
        card_Sparkling.setOnClickListener(this);
        card_Fortified.setOnClickListener(this);
        card_Champagne.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.wt_card_1:
                i=new Intent(getContext(),Red_Wine.class);
                startActivity(i);
                break;

            case R.id.wt_card_2:
                i=new Intent(getContext(),Red_Wine.class);
                startActivity(i);
                break;

            case R.id.wt_card_3:
                i=new Intent(getContext(),Rose_Wine.class);
                startActivity(i);
                break;

            case R.id.wt_card_4:
                i=new Intent(getContext(),Red_Wine.class);
                startActivity(i);
                break;

            case R.id.wt_card_5:
                i=new Intent(getContext(),Red_Wine.class);
                startActivity(i);
                break;

            case R.id.wt_card_6:
                i=new Intent(getContext(),Red_Wine.class);
                startActivity(i);
                break;

            case R.id.wt_card_7:
                i=new Intent(getContext(),Champagne.class);
                startActivity(i);
                break;
        }

    }

}
