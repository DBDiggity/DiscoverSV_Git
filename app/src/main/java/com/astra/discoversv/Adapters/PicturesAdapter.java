package com.astra.discoversv.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astra.discoversv.Items.PictureCard;
import com.astra.discoversv.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.MyViewHolder>{

    private Context context;
    private List<PictureCard> pictureCards;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView background;

        public MyViewHolder(View v){
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            background = (ImageView) v.findViewById(R.id.background);

        }

    }

    public PicturesAdapter(Context context, List<PictureCard> pictureCards) {
        this.context = context;
        this.pictureCards = pictureCards;
    }

    @NonNull
    @Override
    public PicturesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image_1, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PicturesAdapter.MyViewHolder holder, int position) {
        PictureCard card = pictureCards.get(position);
        holder.title.setText(card.getName());

        Glide.with(context).load(card.getBackground()).into(holder.background);

    }

    @Override
    public int getItemCount() {
        return pictureCards.size();
    }
}
