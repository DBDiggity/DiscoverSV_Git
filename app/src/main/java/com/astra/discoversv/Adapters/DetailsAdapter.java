package com.astra.discoversv.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astra.discoversv.Items.Hotel;
import com.astra.discoversv.Items.PictureCard;
import com.astra.discoversv.Items.Restaurant;
import com.astra.discoversv.Items.Site;
import com.astra.discoversv.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyViewHolder>{

    private Context context;
    private String detailType;

    private List<Hotel> hotels;
    private List<Restaurant> restaurants;
    private  List<Site> sites;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView background;

        public MyViewHolder(View v){
            super(v);
            title = (TextView) v.findViewById(R.id.card_details_title);
            background = (ImageView) v.findViewById(R.id.card_details_background);

        }

    }

    public DetailsAdapter(Context context, String detailType) {
        this.context = context;
        this.detailType = detailType;

        if (detailType.equals("hotels"))
            hotels = new Hotel().initHotels();
        else if (detailType.equals("restaurants"))
            restaurants = new Restaurant().initRestaurants();
        else if (detailType.equals("sites"))
            sites = new Site().initSites();
    }


    @NonNull
    @Override
    public DetailsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_details_main, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.MyViewHolder holder, int position) {

        String title = "";
        int image = 0;

        if (detailType.equals("hotels")) {
            Hotel hotel = hotels.get(position);
            title = hotel.getName();
            image = hotel.getHotelImages()[0];
            if (image == 0)
                image = R.drawable.no_hotel;

        } else if (detailType.equals("restaurants")) {
            Restaurant restaurant = restaurants.get(position);
            title = restaurant.getName();
            image = restaurant.getPictures()[0];
            if (image == 0)
                image = R.drawable.no_restaurant;
        } else if (detailType.equals("sites")){
            Site site = sites.get(position);
            title = site.getName();
            image = site.getSitePics()[0];
            if (image == 0)
                image = R.drawable.no_site;
        }

        holder.title.setText(title);
        Glide.with(context).load(image).into(holder.background);
    }

    @Override
    public int getItemCount() {

        if (detailType.equals("hotels")){
            return hotels.size();
        } else if (detailType.equals("restaurants")) {
            return restaurants.size();
        } else if (detailType.equals("sites"))
            return sites.size();
        return 0;
    }
}
