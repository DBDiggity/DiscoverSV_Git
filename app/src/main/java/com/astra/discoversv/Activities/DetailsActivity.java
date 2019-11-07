package com.astra.discoversv.Activities;

import android.os.Bundle;

import com.astra.discoversv.Adapters.DetailsAdapter;
import com.astra.discoversv.Items.Hotel;
import com.astra.discoversv.Items.PictureCard;
import com.astra.discoversv.Items.Restaurant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.astra.discoversv.R;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.details_Rv) DiscreteScrollView details_Rv;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.details_description) TextView descriptionText;
    @BindView(R.id.details_description_title) TextView descriptionTitle;

    List<PictureCard> picCards = new ArrayList<>();

    InfiniteScrollAdapter wrapper;

    private String detailType;
    private List<Hotel> hotels;
    private List<Restaurant> restaurants;
//    private List<Sites> sites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        try {
            detailType = getIntent().getStringExtra("detailType");
//            Toast.makeText(this, detailType, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, detailType, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initDetailsInfo();
        initRecycler();


        descriptionText.setMovementMethod(new ScrollingMovementMethod());
    }

    private void initDetailsInfo(){

        switch (detailType) {
            case "hotels":
                hotels = new Hotel().initHotels();
                getSupportActionBar().setTitle("Hotels");
                break;
            case "restaurants":
                restaurants = new Restaurant().initRestaurants();
                getSupportActionBar().setTitle("Restaurants");
                break;
        }

    }

    private void initRecycler(){

        wrapper = InfiniteScrollAdapter.wrap(new DetailsAdapter(this, detailType));
        details_Rv.setAdapter(wrapper);
        details_Rv.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.05f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());


        details_Rv.addOnItemChangedListener(new DiscreteScrollView.OnItemChangedListener<RecyclerView.ViewHolder>() {
            @Override
            public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {

                switch (detailType){
                    case "hotels":
                        Hotel hotel = hotels.get(wrapper.getRealCurrentPosition());
                        descriptionText.setText(hotel.getDescription());
                        descriptionTitle.setText(hotel.getName());
                        break;
                    case "restaurants":
                        Restaurant restaurant = restaurants.get(wrapper.getRealCurrentPosition());
                        descriptionText.setText(restaurant.getDescription());
                        descriptionTitle.setText(restaurant.getName());
                }


            }
        });

    }

    private void checkMenu(int[] menuList){
        if (menuList.length != 0){

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
