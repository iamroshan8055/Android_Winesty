package com.example.roshantirthyash_groupproj;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<products> mDataset;

    MyAdapter(ArrayList<products> wineList){
        mDataset = wineList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){

        products dish = mDataset.get(position);

        holder.name.setText(dish.getWine_name());
        holder.image.setImageResource(Integer.parseInt((String.valueOf(dish.getWine_image()))));
        holder.price.setText("$"+dish.getWine_price());
        holder.rat_bar.setRating(dish.getWine_star());
    }

    @Override
    public int getItemCount(){
        return mDataset.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name,price;
        ImageView image;
        RatingBar rat_bar;

        MyViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.products, parent, false));
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.text_1);
            image=itemView.findViewById(R.id.image_1);
            price=itemView.findViewById(R.id.text_2);
            rat_bar=itemView.findViewById(R.id.text_rat);
        }
        public void onClick(View view) {
            int position = getLayoutPosition();
            products selected = mDataset.get(position);

            Intent intent = new Intent(this.itemView.getContext(), com.example.roshantirthyash_groupproj.Display.class);
            Log.i("info","------Hello you have clicked------");
            intent.putExtra("title", selected.getWine_name());
            intent.putExtra("image",selected.getWine_image());
            intent.putExtra("price", selected.getWine_price());
            intent.putExtra("star", selected.getWine_star());
            intent.putExtra("description",selected.getWine_description());
            intent.putExtra("quantity",selected.getWine_quantity());
            intent.putExtra("regions", selected.getWine_regions());
            intent.putExtra("volume", selected.getWine_volume());
            intent.putExtra("sweetness", selected.getWine_sweetness());
            intent.putExtra("color", selected.getWine_color());
            intent.putExtra("year", selected.getWine_year());
            this.itemView.getContext().startActivity(intent);

        }
    }

}
