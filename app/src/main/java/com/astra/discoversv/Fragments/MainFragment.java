package com.astra.discoversv.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import com.astra.discoversv.Activities.DetailsActivity;
import com.astra.discoversv.Adapters.PicturesAdapter;
import com.astra.discoversv.Adapters.QuickHorizontalAdapter;
import com.astra.discoversv.Classes.GravitySnapHelper;
import com.astra.discoversv.Classes.SliderTimer;
import com.astra.discoversv.Classes.SpeedSlowScroller;
import com.astra.discoversv.Items.PictureCard;
import com.astra.discoversv.Items.QuickHorizontalCard;
import com.astra.discoversv.R;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {

    //    Views
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.recycler_destination) RecyclerView destinationRV;
    @BindView(R.id.recycler_experience) RecyclerView experienceRV;
    @BindView(R.id.recycler_thingsToDo) RecyclerView ttd_Rv;
    @BindView(R.id.recycler_hotels) RecyclerView hotel_Rv;
    @BindView(R.id.recycler_restaurants) RecyclerView restaurant_Rv;

    @BindView(R.id.destinations_all) Button destinationAll;
    @BindView(R.id.hotel_all) Button hotelAll;
    @BindView(R.id.restaurant_all) Button restaurantAll;

    @BindView(R.id.exo_player) PlayerView playerView;

    //    Variables
    private QuickHorizontalAdapter adapter;
    private List<QuickHorizontalCard> qhCards;
    public PicturesAdapter destinationAdapter, experienceAdapter, thingsToDoAdapter, hotelsAdapter, restaurantAdapter;
    public List<PictureCard> destinationCards, experienceCards, thingsToDoCards, hotelCards, restaurantCards;

    public Context context;

    SimpleExoPlayer player;
    RequestOptions options;

    public MainFragment() {
    }

    public static MainFragment newInstance(){
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        mainFragment.setArguments(args);
        return mainFragment;
    }


        @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, itemView);

        context = itemView.getContext();
        initRecyclerView();
        initPlayer();
        prepareCards();
        initViewAlls();


        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        return itemView;

    }


    @Override
    public void onPause() {
        super.onPause();
        if (player != null){
            player.release();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO: Get current video time and restart from there when resumed
        initPlayer();
    }


    private void initViewAlls(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.hotel_all:
                        popUpMenu();
                        Intent intent = new Intent(getActivity(), DetailsActivity.class);
                        intent.putExtra("detailType", "hotels");
                        startActivity(intent);
                        break;

                    case R.id.restaurant_all :
                        popUpMenu();
                        break;

                    case R.id.destinations_all:
                        popUpMenu();
                        break;
                }
            }
        };

        destinationAll.setOnClickListener(listener);
        hotelAll.setOnClickListener(listener);
        restaurantAll.setOnClickListener(listener);
    }

    private void popUpMenu(){
        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
    }

    private void initPlayer(){
        player = ExoPlayerFactory.newSimpleInstance(context);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, "Discover SVG"));
//        Uri url = Uri.parse("http://www.tourism.gov.vc/tourism/images/mp3/abc.mp4");
        Uri url = Uri.parse("http://www.tourism.gov.vc/tourism/images/mp3/abc.mp4");
        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(url);
        ClippingMediaSource clippingSource =
                new ClippingMediaSource(
                        videoSource,  /* startPositionUs= */ 12_000_000,
                        /* endPositionUs= */ 68_000_000);
        player.prepare(clippingSource);
        player.setRepeatMode(Player.REPEAT_MODE_ONE);
        playerView.setPlayer(player);
    }

    private void initHoriztonalRecycler(RecyclerView rView, @Nullable List<PictureCard> pCards, @Nullable PicturesAdapter phAdapter,
                                        @Nullable List<QuickHorizontalCard> qhCards, @Nullable QuickHorizontalAdapter qhAdapter){
        rView.setItemAnimator(new DefaultItemAnimator());
        rView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));

        if (pCards != null){
            rView.setAdapter(phAdapter);
        } else if (qhCards != null) {
            rView.setAdapter(qhAdapter);
            SnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
            snapHelper.attachToRecyclerView(rView);

        }
    }


    private void initRecyclerView(){

        qhCards = new ArrayList<>();
        destinationCards = new ArrayList<>();
        experienceCards = new ArrayList<>();
        thingsToDoCards = new ArrayList<>();
        hotelCards = new ArrayList<>();
        restaurantCards=new ArrayList<>();

        adapter = new QuickHorizontalAdapter(context, qhCards);


        destinationAdapter = new PicturesAdapter(context, destinationCards);
        experienceAdapter = new PicturesAdapter(context, experienceCards);
        thingsToDoAdapter = new PicturesAdapter(context, thingsToDoCards);
        hotelsAdapter = new PicturesAdapter(context, hotelCards);
        restaurantAdapter = new PicturesAdapter(context, restaurantCards);

        initHoriztonalRecycler(recyclerView, null, null, qhCards, adapter);
        initHoriztonalRecycler(destinationRV, destinationCards, destinationAdapter, null, null);
        initHoriztonalRecycler(experienceRV, experienceCards, experienceAdapter, null, null);
        initHoriztonalRecycler(ttd_Rv, thingsToDoCards, thingsToDoAdapter, null, null);
        initHoriztonalRecycler(hotel_Rv, hotelCards, hotelsAdapter, null, null);
        initHoriztonalRecycler(restaurant_Rv, restaurantCards, restaurantAdapter, null, null);
    }

    private void prepareCards(){

        int[] pictures = new int[]{
                R.drawable.bridge_ocean,
                R.drawable.beach_birdseye,
                R.drawable.city_beach,

        };

        int[] destinationPics = new int[]{
                R.drawable.people_beach,
                R.drawable.night_beach,
                R.drawable.woman_boat,
                R.drawable.cloud_beach
        };

        int[] expPics = new int[]{
                R.drawable.chicken_rice,
                R.drawable.gardens_botanical,
                R.drawable.carnival_red,
                R.drawable.boat_beach
        };

        int[] ttd_Pics = new int[]{
                R.drawable.carnival_svg,
                R.drawable.tourist_beach,
                R.drawable.volcano_top,
                R.drawable.tourists_phone,
                R.drawable.bridge_ocean,
                R.drawable.stew_bowl
        };

        int[] hotel_images = new int[]{
                R.drawable.blue_lagoon1,
                R.drawable.hotel_alexandrina1,
                R.drawable.sunset_shores,
                R.drawable.paradise_inn
        };

        int[] restaurant_images = new int[]{
                R.drawable.driftwood_1,
                R.drawable.yi_1,
                R.drawable.loft_3,
                R.drawable.prestige_1,
                R.drawable.signature_5
        };

        List<String> names = new ArrayList<>();
        names.add("Pier 86");
        names.add("Grant's Beach");
        names.add("Queenstown");

        List<String> destinationNames = new ArrayList<>();
        destinationNames.add("Villa Beach");
        destinationNames.add("Nighttime in the Grenadines");
        destinationNames.add("River 14");
        destinationNames.add("Young island");

        List<String> expNames = new ArrayList<>();
        expNames.add("Peleau");
        expNames.add("Historical Gardens");
        expNames.add("Cultural Festivals");
        expNames.add("Boat Rides");

        List<String > ttd_names = new ArrayList<>();
        ttd_names.add("Carnival");
        ttd_names.add("Explore");
        ttd_names.add("Hiking");
        ttd_names.add("Meet the locals");
        ttd_names.add("The View");
        ttd_names.add("Food");

        List<String> hotels = new ArrayList<>();
        hotels.add("Blue Lagoon");
        hotels.add("Hotel Alexandrina");
        hotels.add("Sunset Shores");
        hotels.add("Paradise Inn");

        List<String> restaurants = new ArrayList<>();
        restaurants.add("Driftwood");
        restaurants.add("Young Island");
        restaurants.add("The Loft");
        restaurants.add("Prestige");
        restaurants.add("Signature");


        prepCards(names, pictures, adapter, null, qhCards, null );
        prepCards(destinationNames, destinationPics, null, destinationAdapter, null, destinationCards);
        prepCards(expNames, expPics, null, experienceAdapter, null, experienceCards);
        prepCards(ttd_names, ttd_Pics, null, thingsToDoAdapter, null, thingsToDoCards);
        prepCards(hotels, hotel_images, null, hotelsAdapter, null, hotelCards);
        prepCards(restaurants, restaurant_images, null, restaurantAdapter, null, restaurantCards);
    }



    //ToDo: Combine prepCards and initRecycler into one method to avoid hardcoding.
    private void prepCards (List<String> names, int[] pics,@Nullable QuickHorizontalAdapter qha, @Nullable PicturesAdapter pa,
                            @Nullable List<QuickHorizontalCard> qhcList, @Nullable List<PictureCard> pcList) {
        if (qha != null) {
            for (int i = 0; i < names.size(); i++) {
                QuickHorizontalCard qhc = new QuickHorizontalCard(pics[i], names.get(i));
                qhcList.add(qhc);
            }

            qha.notifyDataSetChanged();
        } else if (pa != null){
            for (int i=0;i<names.size(); i++){
                PictureCard pc = new PictureCard(names.get(i), pics[i]);
                pcList.add(pc);
            }

            pa.notifyDataSetChanged();
        }
    }



}
