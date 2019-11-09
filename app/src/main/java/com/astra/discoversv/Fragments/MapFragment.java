package com.astra.discoversv.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.astra.discoversv.Items.EntertainmentTypes;
import com.astra.discoversv.Items.Hotel;
import com.astra.discoversv.Items.Restaurant;
import com.astra.discoversv.Items.Site;
import com.astra.discoversv.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapFragment extends Fragment {

    @BindView(R.id.map_fab) SpeedDialView mapFab;

    private List<Marker> hotelList = new ArrayList<>();
    private List<Marker> restaurantList = new ArrayList<>();
    public List<Marker> sitesList = new ArrayList<>();

    Context context;
    int siteCounter = 1;
    private boolean restaurantToggle, hotelToggle, siteToggle;


    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance(){
        MapFragment mapFragment = new MapFragment();
        Bundle args = new Bundle();
        mapFragment.setArguments(args);
        return mapFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //ToDo: Make FAB that allows user to get directions/find themselves
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, rootView);

        context = rootView.getContext();

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frg);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


                CameraPosition googlePlex = CameraPosition.builder()
                        .target(new LatLng(13.148104,-61.223862))
                        .zoom(12)
                        .bearing(0)
                        .tilt(45)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);

                mMap.clear();
                addMarker2Map(mMap);
            }
        });

        initFAB();
        return rootView;
    }

    private int idPath(String name, String type, String packageName){

        return context.getResources().getIdentifier(name, type, packageName);

    }

    private void initFAB(){


        SpeedDialActionItem restaurantAction = new SpeedDialActionItem.Builder(R.id.fab_restaurants, R.drawable.restaurant_marker)
                .setLabel("Toggle Restaurants")
                .setFabBackgroundColor(context.getColor(R.color.colorAccentLight))
                .create();

        SpeedDialActionItem hotelAction = new SpeedDialActionItem.Builder(R.id.fab_hotels, R.drawable.hotel_marker)
                .setLabel("Toggle Hotels")
                .setFabBackgroundColor(context.getColor(R.color.colorAccentLight))
                .create();

        SpeedDialActionItem siteAction = new SpeedDialActionItem.Builder(R.id.fab_sites, R.drawable.site_marker)
                .setLabel("Toggle Sites")
                .setFabBackgroundColor(context.getColor(R.color.colorAccentLight))
                .create();

//        mapFab.inflate(R.menu.map_menu);
        mapFab.addActionItem(restaurantAction, 0);
        mapFab.addActionItem(hotelAction, 1);
        mapFab.addActionItem(siteAction, 2);


        mapFab.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem actionItem) {


                switch (Objects.requireNonNull(actionItem.getLabel(context))){
                    case "Toggle Restaurants":

                        toggleMarkers(restaurantList, restaurantToggle, 0, actionItem, restaurantAction);
                        restaurantToggle = !restaurantToggle;
                        break;


                    case "Toggle Hotels":

                        toggleMarkers(hotelList, hotelToggle, 1, actionItem, hotelAction);
                        hotelToggle = !hotelToggle;
                        break;

                    case "Toggle Sites":
                        cycleMarkers(sitesList, siteToggle, 2, actionItem, siteAction);
                        siteToggle = !siteToggle;
                        break;
                }

                mapFab.close();
                return true;
            }
        });

    }

    private void cycleMarkers(List<Marker> markerList, boolean toggle, int position, SpeedDialActionItem actionItem, SpeedDialActionItem replacement){

        int[] fabIds = new int[]{
          R.id.fab_replace_1,
          R.id.fab_replace_2,
          R.id.fab_replace_3,
          R.id.fab_replace_4,
          R.id.fab_replace_5,
          R.id.fab_replace_6,
          R.id.fab_replace_7,
          R.id.fab_replace_8,
          R.id.fab_replace_9
        };

        switch (siteCounter){

            case 1:
                mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[siteCounter], R.drawable.hike_marker)
                        .setFabBackgroundColor(context.getColor(R.color.colorAccentLight)).setLabel(actionItem.getLabel(context)).create(), position);
                break;
            case 2:
                mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[siteCounter], R.drawable.beach_marker)
                        .setFabBackgroundColor(context.getColor(R.color.colorAccentLight)).setLabel(actionItem.getLabel(context)).create(), position);
                break;
            case 3:
                mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[siteCounter], R.drawable.explore_marker)
                        .setFabBackgroundColor(context.getColor(R.color.colorAccentLight)).setLabel(actionItem.getLabel(context)).create(), position);
                break;
            case 4:
                mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[siteCounter], R.drawable.fort_marker)
                        .setFabBackgroundColor(context.getColor(R.color.colorAccentLight)).setLabel(actionItem.getLabel(context)).create(), position);
                break;
            case 5:
                mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[siteCounter], R.drawable.fun_marker)
                        .setFabBackgroundColor(context.getColor(R.color.colorAccentLight)).setLabel(actionItem.getLabel(context)).create(), position);
                break;
            case 6:
                mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[siteCounter], R.drawable.falls_marker)
                        .setFabBackgroundColor(context.getColor(R.color.colorAccentLight)).setLabel(actionItem.getLabel(context)).create(), position);
                break;
            case 7:
                mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[siteCounter], R.drawable.relax_marker)
                        .setFabBackgroundColor(context.getColor(R.color.colorAccentLight)).setLabel(actionItem.getLabel(context)).create(), position);
                break;
            case 8:
                mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[siteCounter], R.drawable.hide_icon)
                        .setFabBackgroundColor(context.getColor(R.color.faded_gray)).setLabel(actionItem.getLabel(context)).create(), position);
                break;

            case 9:
                mapFab.replaceActionItem(replacement, position);
                break;

        }

            checkSite(markerList, siteCounter);
    }

    private void checkSite(List<Marker> markers, int siteType){

        List<Marker> filtered = new ArrayList<>();

        for (Marker marker : markers){

            marker.setVisible(false);
            int tag = (int) marker.getTag();
            if (tag == siteType)
                filtered.add(marker);
        }

        for (Marker marker : filtered){
            marker.setVisible(true);
        }


        siteCounter++;
        if (siteCounter > 9) {
            for (Marker marker : markers){

                marker.setVisible(true);
                }
            siteCounter = 1;
        }
    }

    private void toggleMarkers(List<Marker> markerList, boolean toggle, int position, SpeedDialActionItem actionItem, SpeedDialActionItem replacement){

        int[] fabIds = new int[]{
                R.id.fab_restaurant_on,
                R.id.fab_restaurant_off,
                R.id.fab_hotel_on,
                R.id.fab_hotel_off
        };

        for (Marker marker : markerList) {
            marker.setVisible(toggle);
        }
        if (!toggle){
            mapFab.replaceActionItem(new SpeedDialActionItem.Builder(fabIds[position], R.drawable.hide_icon)
                    .setFabBackgroundColor(context.getColor(R.color.faded_gray)).setLabel(actionItem.getLabel(context)).create(), position);
        } else {
            mapFab.replaceActionItem(replacement, position);
        }

    }


    public void addMarker2Map(GoogleMap mMap) {


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(13.148104, -61.223862))
                .title("You Are Here"));
//                        .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.spider)));

        List<Restaurant> restaurants = new Restaurant().initRestaurants();
        List<Hotel> hotels = new Hotel().initHotels();
        List<Site> sites = new Site().initSites();
        int tag = 0;

        for (Restaurant restaurant : restaurants){
            restaurantList.add(mMap.addMarker(new MarkerOptions().
                    position(restaurant.getCoords()).
                    title(restaurant.getName()).
                    snippet(restaurant.getDescription()).
                    icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant_circle))));
        }

      for (Hotel hotel : hotels){
          hotelList.add(mMap.addMarker(new MarkerOptions().
                  position(hotel.getCoords()).
                  title(hotel.getName()).
                  snippet(hotel.getDescription()).
                  icon(BitmapDescriptorFactory.fromResource(R.drawable.hotel_circle))));
      }


      for (Site site : sites){
          BitmapDescriptor markerIcon;

          switch (site.getEntertainmentType()){
              case 1:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.hike_circle);
                  tag = EntertainmentTypes.HIKING;
                  break;
              case 2:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.beach_circle);
                  tag = EntertainmentTypes.BEACH;
                  break;
               case 3:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.explore_circle);
                  tag = EntertainmentTypes.EXPLORATION;
                  break;
              case 4:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.fort_circle);
                  tag = EntertainmentTypes.HISTORICAL;
                  break;
              case 5:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.fun_circle);
                  tag = EntertainmentTypes.FUN;
                  break;
              case 6:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.falls_circle);
                  tag = EntertainmentTypes.FALLS;
                  break;
              case 7:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.relax_circle);
                  tag = EntertainmentTypes.RELAXATION;
                  break;
                  default:
                      markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.site_circle);

          }

          Marker marker = mMap.addMarker(new MarkerOptions().
                  position(site.getCoords()).
                  title(site.getName()).
                  snippet(site.getDescription()).
                  icon(markerIcon));

          marker.setTag(tag);

          sitesList.add(marker);


      }

    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

}