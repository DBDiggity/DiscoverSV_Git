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
                "Ratho Mill", "Blue Lagoon Hotel and Marina Ltd features a restaurant, outdoor swimming pool, a fitness centre and bar in Kingstown.",
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
                "Villa", "Welcome to our seaside hotel featuring international cuisine, a popular beach bar, sparkling pool, and dock for visiting yachters.",
                new int[]{R.drawable.mariners_hotel1},
                new int[]{75, 95, 115, 123, 160, 170, 195},
                new String[]{"Standard", "Superior Garden View", "Ocean View", "Deluxe Ocean View", "Super Deluxe King", "Super Deluxe Double Queen",
                        "Super Deluxe Suite"},
                new String[]{"Restaurant", "Dinners"},
                new LatLng(13.132311, -61.199717)
                ));

        //Rosewood
        hotels.add(new Hotel("Rosewood Apartment Hotel","1-784-457-5051",
                "Rose Cottage, Villa", "At Rosewood Apartment Hotel, beautiful scenery and panoramic views abound!",
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

//        //Paradise Inn
//        hotels.add(new Hotel("Paradise Inn","1-784-457-4795",
//                "Villa Beach", "",
//                new int[]{R.drawable.paradise_inn},
//                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
//                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
//                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
//                new String[]{""},
//                new LatLng(13.134237, -61.201582)));

//TODO: Add in additional hotel info (phone/pics/etc)
        //Spring Garden Resort
        hotels.add(new Hotel("Spring Garden Resort","1-784-457-4795",
                "Spring", " We offer Luxurious Suites with breath taking views. Our Highly praised outdoor swimming pool overlooks the splendid landscape of the beautiful garden scenery.",
                new int[]{R.drawable.poolover_lores},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.185358, -61.142816)));


        //Paradise Inn
        hotels.add(new Hotel("Paradise Inn","1-784-457-4795",
                "Villa Beach", "A warm welcome to the Caribbean you have been looking for. St. Vincent and the Grenadines is blessed with beautiful places and friendly faces that have withstood the changing times.",
                new int[]{R.drawable.paradise_inn},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.134237, -61.201582)));


        //Mandarin Oriental
        hotels.add(new Hotel("Mandarin Oriental","1-784-457-4795",
                "Canouan", " The resort is home to a collection of atmospheric restaurants offering a variety of culinary delights accompanied by stunning ocean views. ",
                new int[]{R.drawable.mandarin},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(12.713741, -61.321217)));



        //Frangipani Hotel
        hotels.add(new Hotel("Frangipani Hotel","1-784-457-4795",
                "Bequia", "The Frangipani, the quintessential small hotel on a small island in the Caribbean.",
                new int[]{R.drawable.fragipini},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.008243, -61.236920)));



        //Bequia Plantation Hotel
        hotels.add(new Hotel("Bequia Plantation Hotel","1-784-457-4795",
                "Bequia", "With its prime beach front location, secluded at the southern end of Admiralty Bay, Plantation Hotel has one of the most breath-taking views on the island.",
                new int[]{R.drawable.poolarea},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(13.005664, -61.238012)));



        //Bequia Beach Hotel, Caribbean  Luxury Resort and Spa.
        hotels.add(new Hotel("Bequia Beach Hotel, Caribbean  Luxury Resort and Spa.","1-784-457-4795",
                "Canouan", "Bequia Beach Hotel is an award-winning five-star luxury boutique resort recognised amongst the best luxury hotels in the Grenadines and of the Caribbean.",
                new int[]{R.drawable.beachhotel},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(12.991761, -61.239484)));

        //Tamarind Beach Hotel
        hotels.add(new Hotel("Tamarind Beach Hotel","1-784-458-8044",
                "Canouan", "A truly special and captivating setting for relaxing or romantic Caribbean escapes, Tamarind Beach Hotel is a characterful, boutique style gem situated on the stunning white sand coastline of Grand Bay, Canouan Island.",
                new int[]{R.drawable.tamarind1, R.drawable.tamarind2, R.drawable.tamarind3},
                new int[]{110, 120, 73, 88, 90, 105, 93, 108 },
                new String[]{"Ocean Front Apartments (Single)", "Ocean Front Apartments (Double)", "Garden View (Single)", "Garden View (Double)",
                        "Superior Garden View (Single)", "Superior Garden View (Double)", "Garden View Apartments (Single)", "Garden View Apartments (Double)"},
                new String[]{""},
                new LatLng(12.704131, -61.329081)));

        return hotels;
    }

}
