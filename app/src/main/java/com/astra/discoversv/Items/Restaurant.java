package com.astra.discoversv.Items;

import com.astra.discoversv.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name, phoneNumber, location, description;
    private int[] pictures, menu;
    private LatLng coords;


    public Restaurant() {
    }

    public Restaurant(String name, String phoneNumber, String location, String description, int[] pictures, int[] menu, LatLng coords) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.description = description;
        this.pictures = pictures;
        this.menu = menu;
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getPictures() {
        return pictures;
    }

    public void setPictures(int[] pictures) {
        this.pictures = pictures;
    }

    public int[] getMenu() {
        return menu;
    }

    public void setMenu(int[] menu) {
        this.menu = menu;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LatLng getCoords() {
        return coords;
    }

    public void setCoords(LatLng coords) {
        this.coords = coords;
    }


        public List<Restaurant> initRestaurants(){
        List<Restaurant> restaurants = new ArrayList<>();

        //The Loft
            restaurants.add(new Restaurant(
                    "The Loft",
                    "1-784-458-4308",
                    "Ratho Mill",
                    "The Loft Restaurant and Bar, located at the Blue Lagoon Hotel & Marina",
                    new int[]{R.drawable.loft_1, R.drawable.loft_3, R.drawable.loft_2, R.drawable.loft_4},
                    new int[]{},
                    new LatLng(13.127832, -61.190621)
                    ));

            //Driftwood
            restaurants.add(new Restaurant(
                    "Driftwood",
                    "1-784-456-8999",
                    "Ratho Mill",
                    "Driftwood Restaurant offers Mediterranean cuisine with a Caribbean flair, a stunning seaward view of Blue Lagoon",
                    new int[]{R.drawable.driftwood_1, R.drawable.driftwood_2, R.drawable.driftwood_3, R.drawable.driftwood_4,
                    R.drawable.driftwood_5},
                    new int[]{},
                    new LatLng(13.128690, -61.192901)
            ));

            //Young Island
            restaurants.add(new Restaurant(
                    "Young Island",
                    "1-784-458-4826",
                    "St. Vincent",
                    " \"Lovely and even seductive, enjoy authentic beachfront dining in open-air, thatched roof huts." +
                            " Surrounded by tropical flowers with the alluring scent of jasmine filling the air, " +
                            "day into night, our restaurant is the ideal setting to savor the distinctive flavors of the Caribbean. Reservations are required\",\n"
                    ,
                    new int[]{R.drawable.yi_1, R.drawable.yi_2, R.drawable.yi_3},
                    new int[]{R.drawable.yi_breakfast, R.drawable.yi_lunch, R.drawable.yi_dinner},
                    new LatLng(13.131297, -61.202049)
            ));

            //Flow Wine Bar and Kitchen
            restaurants.add(new Restaurant(
                    "Flow Wine Bar and Kitchen",
                    "1-784-457-0809",
                    "Kingstown",
                    "Ascend a flight of stairs from bustling Kingstown and you will arrive at Flow Wine Bar & Kitchen. " +
                            "Conceived as an exciting urban destination it is a new approach to the good life, specialising in wine with a kitchen to appeal to any appetite." +
                            " The aim is simple; Flow provides a completely elegant, sensual, yet casual experience.",
                    new int[]{R.drawable.flow_1, R.drawable.flow_2},
                    new int[]{R.drawable.flow_menu, R.drawable.flow_menu_2, R.drawable.flow_menu_3},
                    new LatLng(13.152311, -61.223114)
            ));

            //Beachcombers
            restaurants.add(new Restaurant(
                    "Beachcombers",
                    "1-784-458-4283",
                    "Villa",
                    "Beachcombers hotel’s open air restaurant & bar “The Deck” allows anyone to enjoy the Caribbean breeze and young island cut while dining on an exquisite cuisine. " +
                            "The restaurant has an amazing selection of international & local favorites cooked with the ingredients that our beautiful country has to provide!",
                    new int[]{R.drawable.bc_1, R.drawable.bc_2, R.drawable.bc_3},
                    new int[]{},
                    new LatLng(13.135076, -61.202214)
            ));

            //Prestige
            restaurants.add(new Restaurant(
                    "Prestige",
                    "1-784-434-6868",
                    "Fountain",
                    "Cocktail bar & lounge, located on the Vigie Highway",
                    new int[]{R.drawable.prestige_1, R.drawable.prestige_2},
                    new int[]{R.drawable.prestige_menu_1, R.drawable.prestige_menu_2},
                    new LatLng(13.150977, -61.198668)
            ));

            //Signature
            restaurants.add(new Restaurant(
                    "Signature Restaurant and Event Centre",
                    "1-784-456-6518",
                    "Fountain",
                    "Driftwood Restaurant offers Mediterranean cuisine with a Caribbean flair, a stunning seaward view of Blue Lagoon",
                    new int[]{R.drawable.signature_1, R.drawable.signature_4, R.drawable.signature_5, R.drawable.signature_2,
                    R.drawable.signature_3},
                    new int[]{},
                    new LatLng(13.149429, -61.202250)
            ));


        return restaurants;

}


}
