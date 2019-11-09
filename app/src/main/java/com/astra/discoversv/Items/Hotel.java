package com.astra.discoversv.Items;

import com.astra.discoversv.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name, phoneNumber, location, description;
    private int[] hotelImages, accomdationRates;
    private String[] acommodations, events;
    private LatLng coords;

    public Hotel() {
    }

    public Hotel(String name, String phoneNumber, String location, String description, int[] hotelImages,
                 int[] accomdationRates, String[] acommodations, String[] events, LatLng coords) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.description = description;
        this.hotelImages = hotelImages;
        this.accomdationRates = accomdationRates;
        this.acommodations = acommodations;
        this.events = events;
        this.coords = coords;
    }

    public Hotel(String name, String phoneNumber, String location, String description, int[] hotelImages, String[] events) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.description = description;
        this.hotelImages = hotelImages;
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int[] getHotelImages() {
        return hotelImages;
    }

    public void setHotelImages(int[] hotelImages) {
        this.hotelImages = hotelImages;
    }

    public int[] getAccomdationRates() {
        return accomdationRates;
    }

    public void setAccomdationRates(int[] accomdationRates) {
        this.accomdationRates = accomdationRates;
    }

    public String[] getAcommodations() {
        return acommodations;
    }

    public void setAcommodations(String[] acommodations) {
        this.acommodations = acommodations;
    }

    public String[] getEvents() {
        return events;
    }

    public void setEvents(String[] events) {
        this.events = events;
    }

    public LatLng getCoords() {
        return coords;
    }

    public void setCoords(LatLng coords) {
        this.coords = coords;
    }

    public List<Hotel> initHotels(){
        //Hotels
        List<Hotel> hotels = new ArrayList<>();
        //Blue Lagoon
        hotels.add(new Hotel("Blue Lagoon","1-784-458-4208",
                "Ratho Mill", "",
                new int[]{R.drawable.blue_lagoon1},
                new int[]{179, 179, 199, 199},
                new String[]{"Deluxe Double Queen Room", "Deluxe King Room", "Deluxe Double Queen w/ Kitchenette", "Deluxe King w/ Kitchenette"},
                new String[]{"Weddings"},
                new LatLng(13.127838, -61.190597))
                );

        //Sunset Shores
        hotels.add(new Hotel("Sunset Shores","1-784-457-4800",
                "Villa", "Free Wifi, Air Conditioning, Room Service, and more. Contact us for more details",
                new int[]{R.drawable.sunset_shores},
                new int[]{0},
                new String[]{"Standard Room"},
                new String[]{"Weddings", "Dinners", "Meetings"},
                new LatLng(13.134556, -61.201820)));

        //Mariners Hotel
        hotels.add(new Hotel("Mariners Hotel","1-784-457-4000",
                "Villa", "",
                new int[]{R.drawable.mariners_hotel1},
                new int[]{75, 95, 115, 123, 160, 170, 195},
                new String[]{"Standard", "Superior Garden View", "Ocean View", "Deluxe Ocean View", "Super Deluxe King", "Super Deluxe Double Queen",
                        "Super Deluxe Suite"},
                new String[]{"Restaurant", "Dinners"},
                new LatLng(13.132311, -61.199717)
                ));

        //Rosewood
        hotels.add(new Hotel("Rosewood Apartment Hotel","1-784-457-5051",
                "Rose Cottage, Villa", "",
                new int[]{R.drawable.rosewood_room1},
                new int[]{68, 74},
                new String[]{"Standard", "Studio"},
                new String[]{""},
                new LatLng(13.138042, -61.201885)));

        //Hotel Alexandrina
        hotels.add(new Hotel("Hotel Alexandrina","1-784-456-9788",
                "Ribishi, Prospect", "Where Comfort & Tranquility Reign",
                new int[]{R.drawable.hotel_alexandrina1},
                new int[]{75, 90, 90, 110, 230, 95, 90, 195, 120, 145, 115, 140},
                new String[]{"Standard ROom (Single)", "Standard Room (Double)", "Deluxe Single Room", "Deluxe Double Room", "Penthouse Suite",  "Garden View Rooms",
                        "Garden View Apartments (Single Bedroom)","Garden View Apartments (Double Bedrooms)",
                        "Two Bedroom Cottage (Single)", "Two Bedroom Cottage (Double)", "Mini Suite (Single)", "Mini Suite (Double)"},
                new String[]{"Weddings", "Meetings", "Day Pass", "Social Events"},
                new LatLng(13.134761, -61.184572)));

        //Paradise Inn
        hotels.add(new Hotel("Paradise Inn","1-784-457-4795",
                "Villa Beach", "",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.134237, -61.201582)));

//TODO: Add in additional hotel info (phone/pics/etc)
        //Spring Garden Resort
        hotels.add(new Hotel("Spring Garden Resort","1-784-457-4795",
                "Spring", "",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.185358, -61.142816)));


        //Paradise Inn
        hotels.add(new Hotel("Paradise Inn","1-784-457-4795",
                "Villa Beach", "",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.134237, -61.201582)));


        //Mandarin Oriental
        hotels.add(new Hotel("Mandarin Oriental","1-784-457-4795",
                "Canouan", "",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(12.713741, -61.321217)));



        //Frangipani Hotel
        hotels.add(new Hotel("Frangipani Hotel","1-784-457-4795",
                "Bequia", "",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.008243, -61.236920)));



        //Bequia Plantation Hotel
        hotels.add(new Hotel("Bequia Plantation Hotel","1-784-457-4795",
                "Bequia", "",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.005664, -61.238012)));



        //Bequia Beach Hotel, Caribbean  Luxury Resort and Spa.
        hotels.add(new Hotel("Bequia Beach Hotel, Caribbean  Luxury Resort and Spa.","1-784-457-4795",
                "Canouan", "",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(12.991761, -61.239484)));



        //Mandarin Oriental
        hotels.add(new Hotel("Tropical Hideaway","1-784-457-4795",
                "Canouan", "",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.000338, -61.236721)));

        return hotels;
    }

}
