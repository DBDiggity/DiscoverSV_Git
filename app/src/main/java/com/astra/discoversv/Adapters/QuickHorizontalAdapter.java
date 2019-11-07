package com.astra.discoversv.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astra.discoversv.Items.QuickHorizontalCard;
import com.astra.discoversv.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class QuickHorizontalAdapter extends RecyclerView.Adapter<QuickHorizontalAdapter.QHViewHolder> {

    private Context context;
    private List<QuickHorizontalCard> qhCards;

    public QuickHorizontalAdapter(Context context, List<QuickHorizontalCard> qhCards) {
        this.context = context;
        this.qhCards = qhCards;
    }

    public class QHViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView background;

        public QHViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            background = (ImageView) itemView.findViewById(R.id.background);
        }
    }

    @NonNull
    @Override
    public QuickHorizontalAdapter.QHViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_qh, parent, false);

        return new QHViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuickHorizontalAdapter.QHViewHolder holder, int position) {

            QuickHorizontalCard card = qhCards.get(position);

            holder.title.setText(card.getDescription());

        Glide.with(context).load(card.getImage()).into(holder.background);

    }

    @Override
    public int getItemCount() {
        return qhCards.size();
    }
}
