package com.astra.discoversv.Items;

import com.astra.discoversv.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Site {

    private String name, description, location;
    private int entertainmentType;
    private LatLng coords;
    private int[] sitePics;

    public Site(String name, String location, String description, int entertainmentType, int[] sitePics, LatLng coords) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.entertainmentType = entertainmentType;
        this.sitePics = sitePics;;
        this.coords = coords;
    }

    public Site() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LatLng getCoords() {
        return coords;
    }

    public void setCoords(LatLng coords) {
        this.coords = coords;
    }

    public int[] getSitePics() {
        return sitePics;
    }

    public void setSitePics(int[] sitePics) {
        this.sitePics = sitePics;
    }

    public int getEntertainmentType() {
        return entertainmentType;
    }

    public void setEntertainmentType(int entertainmentType) {
        this.entertainmentType = entertainmentType;
    }

    public List<Site> initSites(){

        List<Site> array = new ArrayList<>();

        //La Soufriere
        array.add(new Site("La Soufriere Trail"
                ,"Georgetown"
                , "Hike La Soufriere!"
                , EntertainmentTypes.HIKING
                ,new int[]{R.drawable.la_soufriere_1}
                ,new LatLng(13.3165194, -61.1526489)));

        //Dark View Falls
        array.add(new Site("Dark View Falls"
                ,"Richmond"
                , "Hike La Soufriere!"
                , EntertainmentTypes.FALLS
                ,new int[]{0}
                ,new LatLng(13.2998129, -61.2274547)));

        //Falls of Belaine
        array.add(new Site("Falls of Belaine"
                ,"Georgetown"
                , "Hike La Soufriere!"
                , EntertainmentTypes.FALLS
                ,new int[]{0}
                ,new LatLng(13.3668168, -61.1915017)));

        //Montreal Garden
        array.add(new Site("Montreal Gardens"
                ,"Georgetown"
                , "Hike La Soufriere!"
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.montreal_gardens}
                ,new LatLng(13.2080527, -61.1866915)));

        //Owia Salt Pond
        array.add(new Site("Owia Salt Pond"
                ,"Owia"
                , "Hike La Soufriere!"
                , EntertainmentTypes.RELAXATION
                ,new int[]{R.drawable.owia_salt}
                ,new LatLng(13.3761914, -61.1395416)));

        //Villa Beach
        array.add(new Site("Villa Beach"
                ,"Villa"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{0}
                ,new LatLng(13.1338087, -61.2016502)));

        //Indian Bay
        array.add(new Site("Indian Bay"
                ,"Villa"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{0}
                ,new LatLng(13.1368115, -61.2068966)));

        //Canash Beach
        array.add(new Site("Canash Beach"
                ,"Georgetown"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{0}
                ,new LatLng( 13.1262992, -61.1897006)));

        //Buccament Bay Beach
        array.add(new Site("Buccament Bay Beach"
                ,"Buccament"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{0}
                ,new LatLng(13.1905342, -61.2671695)));

        //Mt. Wynne
        array.add(new Site("Mt. Wynne"
                ,"Mt. Wynne"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.mt_wynne_1}
                ,new LatLng(13.216340, -61.275238)));

        //Botanical Gardens
        array.add(new Site("Botanical Gardens"
                ,"Kingstown"
                , "Hike La Soufriere!"
                , EntertainmentTypes.RELAXATION
                ,new int[]{0}
                ,new LatLng(13.164796, -61.227385)));

        //Fort Charlotte
        array.add(new Site("Fort Charlotte"
                ,"Edin Boro"
                , "Hike La Soufriere!"
                , EntertainmentTypes.HISTORICAL
                ,new int[]{0}
                ,new LatLng(13.157906, -61.242106)));

        //Fort Duvernette
        array.add(new Site("Fort Duvernette"
                ,"Villa"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.fort_duvernette_1}
                ,new LatLng(13.127945, -61.203846)));

        //Belmont Lookout
        array.add(new Site("Belmont Lookout"
                ,"Belmont"
                , "Hike La Soufriere!"
                , EntertainmentTypes.RELAXATION
                ,new int[]{0}
                ,new LatLng(13.165033, -61.179502)));

        //Walliabou Heritage Park
        array.add(new Site("Walliabou Heritage Park"
                ,"Walliabou"
                , "Hike La Soufriere!"
                , EntertainmentTypes.RELAXATION
                ,new int[]{R.drawable.walliabou_1}
                ,new LatLng(13.248189, -61.260628)));


        //Rawacou
        array.add(new Site("Rawacou Recreational Park"
                ,"Argyle"
                , "Hike La Soufriere!"
                , EntertainmentTypes.RELAXATION
                ,new int[]{0}
                ,new LatLng(13.151297,  -61.147938)));


        //Black Point Tunnel
        array.add(new Site("Black Point Tunnel and Recreational Park"
                ,"Byera"
                , "Hike La Soufriere!"
                , EntertainmentTypes.RELAXATION
                ,new int[]{0}
                ,new LatLng(13.263079, -61.117117)));

        //Kingstown Cruise Ship and Ferry Terminal
        array.add(new Site("Kingstown Cruise Ship and Ferry Terminal"
                ,"Kingstown"
                , "Hike La Soufriere!"
                , 0
                ,new int[]{0}
                ,new LatLng(13.148930, -61.223260)));

        //Argyle International Airport
        array.add(new Site("Argyle International Airport"
                ,"Argyle"
                , "Hike La Soufriere!"
                , 0
                ,new int[]{0}
                ,new LatLng(13.164113, -61.151375)));


        //------------ Grenadines ----------------//


        //Princess Margaret Beach
        array.add(new Site("Princess Margaret Beach"
                ,"Grenadines"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.princess_margaret_1}
                ,new LatLng(13.000923, -61.241247)));


        //Lower Bay Beach
        array.add(new Site("Lower Bay Beach"
                ,"Grenadines"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.lower_bay_1}
                ,new LatLng(12.996511, -61.246048)));


        //Canouan Golf Course
        array.add(new Site("Canouan Gold Course"
                ,"Grenadines"
                , "Have a game of golf"
                , EntertainmentTypes.FUN
                ,new int[]{R.drawable.canouan_1}
                ,new LatLng(12.720785, -61.323937)));

        //Macaroni beach
        array.add(new Site("Macaroni Beach"
                ,"Grenadines"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.macaroni_beach_1}
                ,new LatLng(12.880317, -61.176350)));


        //Mopion Island
        array.add(new Site("Mopion Island"
                ,"Grenadines"
                , "Chill underneath the Engagement Umbrella"
                , EntertainmentTypes.FUN
                ,new int[]{R.drawable.mopion_1}
                ,new LatLng(12.546244, -61.395341)));


        //Mayreau, Salt Whistle bay
        array.add(new Site("Salt Whistle Bay"
                ,"Grenadines"
                , "Hike La Soufriere!"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.salt_whistle_1}
                ,new LatLng(12.646623, -61.389990)));

        //Petite St. Vincent
        array.add(new Site("Petite St. Vincent"
                ,"Grenadines"
                , "Hike La Soufriere!"
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.petit_svg}
                ,new LatLng(12.536795, -61.383724)));

        //Petit Tabac
        array.add(new Site("Petite Tabac"
                ,"Grenadines"
                , "Hike La Soufriere!"
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.petit_tabac_1}
                ,new LatLng(12.623197, -61.348331)));

        //Palm Island
        array.add(new Site("Palm Island"
                ,"Grenadines"
                , "Hike La Soufriere!"
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.palm_island_1}
                ,new LatLng(12.586495, -61.396696)));

        return array;
    }
}
