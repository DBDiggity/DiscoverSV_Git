package com.astra.discoversv.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astra.discoversv.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private int[] menues;
    private Context context;

    public MenuAdapter(int[] menues, Context context) {
        this.menues = menues;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView menu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            menu = (itemView.findViewById(R.id.card_menu_pic));
        }
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_menu, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int menu = menues[position];
        holder.menu.setImageResource(menu);

    }

    @Override
    public int getItemCount() {
        return menues.length;
    }
}
