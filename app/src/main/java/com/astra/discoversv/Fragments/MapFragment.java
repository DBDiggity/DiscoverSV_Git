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
                        .zoom(15)
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

        SpeedDialActionItem siteAction = new SpeedDialActionItem.Builder(R.id.fab_sites, R.drawable.taxi_marker)
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
                        toggleMarkers(sitesList, siteToggle, 2, actionItem, siteAction);
                        siteToggle = !siteToggle;
                        break;
                }

                mapFab.close();
                return true;
            }
        });

    }

    private void toggleMarkers(List<Marker> markerList, boolean toggle, int position, SpeedDialActionItem actionItem, SpeedDialActionItem replacement){

        int[] fabIds = new int[]{
          R.id.fab_replace_1,
          R.id.fab_replace_2,
          R.id.fab_replace_3,
          R.id.fab_replace_4,
          R.id.fab_replace_5
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

        for (Restaurant restaurant : restaurants){
            restaurantList.add(mMap.addMarker(new MarkerOptions().
                    position(restaurant.getCoords()).
                    title(restaurant.getName()).
                    snippet(restaurant.getDescription()).
                    icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant_marker))));
        }

      for (Hotel hotel : hotels){
          hotelList.add(mMap.addMarker(new MarkerOptions().
                  position(hotel.getCoords()).
                  title(hotel.getName()).
                  snippet(hotel.getDescription()).
                  icon(BitmapDescriptorFactory.fromResource(R.drawable.hotel_marker))));
      }


      for (Site site : sites){
          BitmapDescriptor markerIcon;

          switch (site.getEntertainmentType()){
              case 1:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.hike_marker);
                  break;
              case 2:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.beach_marker);
                  break;
               case 3:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.explore_marker);
                  break;
              case 4:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.fort_marker);
                  break;
              case 5:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.fun_marker);
                  break;
              case 6:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.falls_marker);
                  break;
              case 7:
                  markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.beach_marker);
                  break;
                  default:
                      markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.site_marker);

          }

          sitesList.add(mMap.addMarker(new MarkerOptions().
                  position(site.getCoords()).
                  title(site.getName()).
                  snippet(site.getDescription()).
                  icon(markerIcon)));


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