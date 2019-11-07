package com.astra.discoversv.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.astra.discoversv.Items.Hotel;
import com.astra.discoversv.Items.Restaurant;

import java.util.List;

public class HotelRestaurantAdapter extends RecyclerView.Adapter<HotelRestaurantAdapter.HRViewHolder> {

    private List<Hotel> hotels;
    private List<Restaurant> restaurants;
    private Context context;

    public HotelRestaurantAdapter(@Nullable List<Hotel> hotels,@Nullable List<Restaurant> restaurants, Context context) {
        this.hotels = hotels;
        this.restaurants = restaurants;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelRestaurantAdapter.HRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelRestaurantAdapter.HRViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        if (!(hotels.isEmpty()))
            return hotels.size();
        return restaurants.size();
    }

    public class HRViewHolder extends RecyclerView.ViewHolder{

        public HRViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
