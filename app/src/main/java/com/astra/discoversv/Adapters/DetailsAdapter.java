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
import com.astra.discoversv.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyViewHolder>{

    private Context context;
    private String detailType;

    private List<Hotel> hotels;
    private List<Restaurant> restaurants;
//    private  List<Sites> sites;

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
    }


    @NonNull
    @Override
    public DetailsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_details_main, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.MyViewHolder holder, int position) {

        if (detailType.equals("hotels")) {
            Hotel hotel = hotels.get(position);
            holder.title.setText(hotel.getName());
            Glide.with(context).load(hotel.getHotelImages()[0]).into(holder.background);
        } else if (detailType.equals("restaurants")) {
            Restaurant restaurant = restaurants.get(position);
            holder.title.setText(restaurant.getName());
            Glide.with(context).load(restaurant.getPictures()[position]).into(holder.background);
        }
    }

    @Override
    public int getItemCount() {

        if (detailType.equals("hotels")){
            return hotels.size();
        } else if (detailType.equals("restaurants")) {
            return restaurants.size();
        } else
        return 0;
    }
}
