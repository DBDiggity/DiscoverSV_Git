package com.astra.discoversv.Activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.astra.discoversv.Adapters.DetailsAdapter;
import com.astra.discoversv.Adapters.MenuAdapter;
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
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.astra.discoversv.R;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
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

    @BindView(R.id.details_btn_info) Button infoBtn;
    @BindView(R.id.details_btn_menu) Button menuBtn;

    List<PictureCard> picCards = new ArrayList<>();

    InfiniteScrollAdapter wrapper;
    DialogPlus dialog;

    private String detailType;
    private List<Hotel> hotels;
    private List<Restaurant> restaurants;
//    private List<Sites> sites;
    private int menuPosition = 0;

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
        initListeners();


        descriptionText.setMovementMethod(new ScrollingMovementMethod());
    }

    private void initDetailsInfo(){

        switch (detailType) {
            case "hotels":
                hotels = new Hotel().initHotels();
                getSupportActionBar().setTitle("Hotels");
                menuBtn.setVisibility(View.GONE);
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
                        checkMenu(restaurant.getMenu());
                        menuPosition = wrapper.getRealCurrentPosition();
                }


            }
        });

    }

    private void checkMenu(int[] menuList){
        if (menuList.length == 0)
            menuBtn.setVisibility(View.INVISIBLE);
        else
            menuBtn.setVisibility(View.VISIBLE);

    }

    private void initListeners(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.details_btn_menu:
                        buildDialog();

                }
            }
        };

        menuBtn.setOnClickListener(listener);
    }

    private void buildDialog(){


        dialog = DialogPlus.newDialog(this)
                .setContentHolder(new ViewHolder(R.layout.layout_menu))
                .setMargin(0, 10, 0, 0)
                .setPadding(0,0,0,0)
                .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setContentHeight(ViewGroup.LayoutParams.MATCH_PARENT)
                .setExpanded(true, 1500)
                .setGravity(Gravity.CENTER)
                .setContentBackgroundResource(R.color.overlay_black)
                .create();
        dialog.show();

        DiscreteScrollView scrollView = (DiscreteScrollView) dialog.getHolderView().findViewById(R.id.menu_scrollView);
        RecyclerView.Adapter adapter = new MenuAdapter(restaurants.get(menuPosition).getMenu(), this);
        scrollView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.05f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
