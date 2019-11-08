package com.astra.discoversv.Activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.astra.discoversv.Adapters.DetailsAdapter;
import com.astra.discoversv.Adapters.MenuAdapter;
import com.astra.discoversv.Items.Hotel;
import com.astra.discoversv.Items.PictureCard;
import com.astra.discoversv.Items.Restaurant;
import com.astra.discoversv.Items.Site;
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
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.astra.discoversv.R;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.details_Rv) DiscreteScrollView details_Rv;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;

    @BindView(R.id.details_description) TextView descriptionText;
    @BindView(R.id.details_description_title) TextView descriptionTitle;

    @BindView(R.id.details_btn_info) Button infoBtn;
    @BindView(R.id.details_btn_menu) Button menuBtn;

    List<PictureCard> picCards = new ArrayList<>();
    InfiniteScrollAdapter wrapper;
    DialogPlus dialog;
    DialogPlus infoDialog;

    private String detailType;
    private List<Hotel> hotels;
    private List<Restaurant> restaurants;
    private List<Site> sites;
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
            case "sites":
                sites = new Site().initSites();
                getSupportActionBar().setTitle("Sites");
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
                        break;
                    case "sites":
                        Site site = sites.get(wrapper.getRealCurrentPosition());
                        descriptionText.setText(site.getDescription());
                        descriptionTitle.setText(site.getName());
                        break;
                }
                menuPosition = wrapper.getRealCurrentPosition();
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
                        break;
                    case R.id.fab:
                        buildInfoDialog();
                        break;

                }
            }
        };

        menuBtn.setOnClickListener(listener);
        fab.setOnClickListener(listener);
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

    private void buildInfoDialog(){

        infoDialog = DialogPlus.newDialog(this)
                .setContentHolder(new ViewHolder(R.layout.dialog_info))
//                .setMargin(0, 10, 0, 0)
                .setPadding(20,20,20,20)
                .setExpanded(true, 1250)
                .setGravity(Gravity.CENTER)
                .setContentBackgroundResource(R.color.overlay_black)
                .setInAnimation(R.anim.abc_fade_in)
                .setOutAnimation(R.anim.abc_fade_out)
                .create();

        initInfoDialog(infoDialog);

        infoDialog.show();


    }


    private void initInfoDialog(DialogPlus infoDialog){
        TextView infoTitle = (TextView) infoDialog.getHolderView().findViewById(R.id.info_title);
        TextView infoLocation = (TextView) infoDialog.getHolderView().findViewById(R.id.info_location);
        RatingBar infoRating = (RatingBar) infoDialog.getHolderView().findViewById(R.id.info_rating);
        DiscreteScrollView infoPicture = (DiscreteScrollView) infoDialog.getHolderView().findViewById(R.id.info_images);
        TextView infoDescription = (TextView) infoDialog.getHolderView().findViewById(R.id.info_description);
        LinearLayout infoRooms = (LinearLayout) infoDialog.getHolderView().findViewById(R.id.info_hotel_facilities);
        DiscreteScrollView infoRoomIcons = (DiscreteScrollView) infoDialog.getHolderView().findViewById(R.id.info_rooms);
        Button infoMenu = (Button) infoDialog.getHolderView().findViewById(R.id.info_menu);
        TextView infoStartsFrom = (TextView) infoDialog.getHolderView().findViewById(R.id.info_startsFrom);
        TextView infoPrice = (TextView) infoDialog.getHolderView().findViewById(R.id.info_price);
        Button infoAction = (Button) infoDialog.getHolderView().findViewById(R.id.info_actionBtn);

        String title = "Title";
        String location = "Location";
        int rating = 4;
        String description = getResources().getString(R.string.lorem);
        int[] images = new int[]{0};
        String startsFrom = "Starts From";
        String price = "$0";
        String action = "Action";

        switch (detailType){
            case "hotels":
                Hotel hotel = hotels.get(menuPosition);

                title = hotel.getName();
                location = hotel.getLocation();
                description = hotel.getDescription();
                startsFrom = "Starts From";
                action = "Book Room";
                if (hotel.getAccomdationRates().length > 0)
                  price = "$" + hotel.getAccomdationRates()[0];

                images = hotel.getHotelImages();

                infoRooms.setVisibility(View.VISIBLE);
                infoMenu.setVisibility(View.INVISIBLE);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) infoAction.getLayoutParams();
                params.removeRule(RelativeLayout.CENTER_VERTICAL);
                params.addRule(RelativeLayout.ALIGN_PARENT_END);
                infoAction.setLayoutParams(params);

                break;
            case "restaurants":
                Restaurant restaurant = restaurants.get(menuPosition);

                title = restaurant.getName();
                location = restaurant.getLocation();
                description = restaurant.getDescription();
                startsFrom = "";
                price = "";
                action = "Call Now";
                images = restaurant.getPictures();

                infoRooms.setVisibility(View.INVISIBLE);
                infoMenu.setVisibility(View.VISIBLE);
                RelativeLayout.LayoutParams xparams = (RelativeLayout.LayoutParams) infoAction.getLayoutParams();
                xparams.removeRule(RelativeLayout.ALIGN_PARENT_END);
                xparams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                infoAction.setLayoutParams(xparams);
                break;

            case "sites":
                Site site = sites.get(menuPosition);

                title = site.getName();
                location = site.getLocation();
                description = site.getDescription();
                startsFrom = "";
                action = "Book Tour";
                price = "";
                images = site.getSitePics();
                break;
        }

        infoTitle.setText(title);
        infoLocation.setText(location);
        infoRating.setNumStars(rating);
        infoDescription.setText(description);
        infoRooms.setVisibility(View.INVISIBLE);
        infoMenu.setVisibility(View.INVISIBLE);
        infoStartsFrom.setText(startsFrom);
        infoPrice.setText(price);
        infoAction.setText(action);


        RecyclerView.Adapter adapter = new MenuAdapter(images, this);
        infoPicture.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        infoPicture.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(0.8f)
                .setMinScale(0.65f)
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
