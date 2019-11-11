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
                , "The La Soufriere Cross Country Trail winds its way from sea level up to the top of the majestic La Soufriere Volcano (4048ft/ 1178m). "
                , EntertainmentTypes.HIKING
                ,new int[]{R.drawable.la_soufriere_1}
                ,new LatLng(13.3165194, -61.1526489)));

        //Dark View Falls
        array.add(new Site("Dark View Falls"
                ,"Richmond"
                , "Dark View Falls are two spectacular waterfalls, one above the other, cascading down high cliff faces and plunging into natural pools. !"
                , EntertainmentTypes.FALLS
                ,new int[]{0}
                ,new LatLng(13.2998129, -61.2274547)));

        //Falls of Belaine
        array.add(new Site("Falls of Belaine"
                ,"Georgetown"
                , "The Falls of Baleine is among St. Vincent's finest natural wonders. The sparkling waters plunge about 60ft into a rock-enclosed fresh water pool, perfect for swimming. "
                , EntertainmentTypes.FALLS
                ,new int[]{0}
                ,new LatLng(13.3668168, -61.1915017)));

        //Montreal Garden
        array.add(new Site("Montreal Gardens"
                ,"Georgetown"
                , "Although smaller than the Botanical Gardens in Kingstown, these gardens still feature many species of exotic plants."
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.montreal_gardens}
                ,new LatLng(13.2080527, -61.1866915)));

        //Owia Salt Pond
        array.add(new Site("Owia Salt Pond"
                ,"Owia"
                , "The Owia Salt Pond is located on the North Eastern Coast of St. Vincent in the village of Owia which is home to some of the indigenous people of St. Vincent and the Grenadines - the Black Caribs."
                , EntertainmentTypes.RELAXATION
                ,new int[]{R.drawable.owia_salt}
                ,new LatLng(13.3761914, -61.1395416)));

        //Villa Beach
        array.add(new Site("Villa Beach"
                ,"Villa"
                , "Enter Description"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.villa_0}
                ,new LatLng(13.1338087, -61.2016502)));

        //Indian Bay
        array.add(new Site("Indian Bay"
                ,"Villa"
                , "Enter Description"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.indian_0}
                ,new LatLng(13.1368115, -61.2068966)));

        //Canash Beach
        array.add(new Site("Canash Beach"
                ,"Georgetown"
                , "Enter Description"
                , EntertainmentTypes.BEACH
                ,new int[]{0}
                ,new LatLng( 13.1262992, -61.1897006)));

        //Buccament Bay Beach
        array.add(new Site("Buccament Bay Beach"
                ,"Buccament"
                , "Enter Description"
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.buccament_0}
                ,new LatLng(13.1905342, -61.2671695)));

        //Mt. Wynne
        array.add(new Site("Mt. Wynne"
                ,"Mt. Wynne"
                , "Mount Wynne Beach is a beautiful Black Sand beach located on the south-western coastline, approximately 11 miles from capital Kingstown."
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.mt_wynne_0}
                ,new LatLng(13.216340, -61.275238)));

        //Botanical Gardens
        array.add(new Site("Botanical Gardens"
                ,"Kingstown"
                , "The Botanical Gardens are one of the most important and popular sites in St Vincent. They are the oldest botanical gardens in the Western Hemisphere (established in 1765)."
                , EntertainmentTypes.RELAXATION
                ,new int[]{0}
                ,new LatLng(13.164796, -61.227385)));

        //Fort Charlotte
        array.add(new Site("Fort Charlotte"
                ,"Edin Boro"
                , "The fort was built in the 1760's with an interesting history of why the cannons are pointed inland. Worth a visit not just for its awesome views and also for its rich history."
                , EntertainmentTypes.HISTORICAL
                ,new int[]{R.drawable.fort_charlotte_0}
                ,new LatLng(13.157906, -61.242106)));

        //Fort Duvernette
        array.add(new Site("Fort Duvernette"
                ,"Villa"
                , "Built around 1800 on a tiny island next to Young Island, this fort once protected a chief port of St. Vincent."
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.fort_duvernette_1}
                ,new LatLng(13.127945, -61.203846)));

        //Belmont Lookout
        array.add(new Site("Belmont Lookout"
                ,"Belmont"
                , "Belmont Lookout offers panoramic views into the picturesque Marriaqua / Mesopotamia Valley to the north and east. "
                , EntertainmentTypes.RELAXATION
                ,new int[]{0}
                ,new LatLng(13.165033, -61.179502)));

        //Walliabou Heritage Park
        array.add(new Site("Walliabou Heritage Park"
                ,"Walliabou"
                , "This small village sits next to a gorgeous bay."
                , EntertainmentTypes.RELAXATION
                ,new int[]{R.drawable.walliabou_1}
                ,new LatLng(13.248189, -61.260628)));


        //Rawacou
        array.add(new Site("Rawacou Recreational Park"
                ,"Argyle"
                , "Rawacou Recreation Park features two beaches separated by a rocky headland with a man-made pool. "
                , EntertainmentTypes.RELAXATION
                ,new int[]{R.drawable.rawacou_0}
                ,new LatLng(13.151297,  -61.147938)));


        //Black Point Tunnel
        array.add(new Site("Black Point Tunnel and Recreational Park"
                ,"Byera"
                , "Enter Description"
                , EntertainmentTypes.RELAXATION
                ,new int[]{0}
                ,new LatLng(13.263079, -61.117117)));

        //Kingstown Cruise Ship and Ferry Terminal
        array.add(new Site("Kingstown Cruise Ship and Ferry Terminal"
                ,"Kingstown"
                , "Enter Description"
                , 0
                ,new int[]{0}
                ,new LatLng(13.148930, -61.223260)));

        //Argyle International Airport
        array.add(new Site("Argyle International Airport"
                ,"Argyle"
                , "Enter Description"
                , 0
                ,new int[]{0}
                ,new LatLng(13.164113, -61.151375)));


        //------------ Grenadines ----------------//


        //Princess Margaret Beach
        array.add(new Site("Princess Margaret Beach"
                ,"Grenadines"
                , "One of Bequia's most popular beaches."
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.princess_margaret_0}
                ,new LatLng(13.000923, -61.241247)));


        //Lower Bay Beach
        array.add(new Site("Lower Bay Beach"
                ,"Grenadines"
                , "This excellent beach is one of the highlights of Bequia."
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.lower_bay}
                ,new LatLng(12.996511, -61.246048)));


        //Canouan Golf Course
        array.add(new Site("Canouan Golf Course"
                ,"Grenadines"
                , "Have a game of golf"
                , EntertainmentTypes.FUN
                ,new int[]{R.drawable.canouan_1}
                ,new LatLng(12.720785, -61.323937)));

        //Macaroni beach
        array.add(new Site("Macaroni Beach"
                ,"Grenadines"
                , "A Mustique beach that is popular with tourists seeking good swimming and snorkeling."
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.macaroni_0}
                ,new LatLng(12.880317, -61.176350)));


        //Mopion Island
        array.add(new Site("Mopion Island"
                ,"Grenadines"
                , "Chill underneath the Engagement Umbrella"
                , EntertainmentTypes.FUN
                ,new int[]{R.drawable.mopion_0}
                ,new LatLng(12.546244, -61.395341)));


        //Mayreau, Salt Whistle bay
        array.add(new Site("Salt Whistle Bay"
                ,"Grenadines"
                , "This pristine tropical bay and its beach are protected from rough Atlantic waters by a small piece of land that extends out into the ocean. "
                , EntertainmentTypes.BEACH
                ,new int[]{R.drawable.salt_whistle_0}
                ,new LatLng(12.646623, -61.389990)));

        //Petite St. Vincent
        array.add(new Site("Petite St. Vincent"
                ,"Grenadines"
                , "This small island is a popular resort destination, similar to its nearby counterpart, Palm Island."
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.petit_svg_1, R.drawable.petit_svg_0, R.drawable.petit_svg}
                ,new LatLng(12.536795, -61.383724)));

        //Petit Tabac
        array.add(new Site("Petite Tabac"
                ,"Grenadines"
                , "Enter Description"
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.petit_tabac_1}
                ,new LatLng(12.623197, -61.348331)));

        //Tobago Cays
        array.add(new Site("Tobago Cays Marine Park"
                ,"Grenadines"
                , "A collection of several uninhabited islands in the southern section of the Grenadines that offer some of the best beaches for swimming, tanning and snorkeling in the Caribbean."
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.tobago_cays}
                ,new LatLng(12.633512, -61.356816)));

        //Palm Island
        array.add(new Site("Palm Island"
                ,"Grenadines"
                , "This small island has recently become a popular resort destination with great beaches."
                , EntertainmentTypes.EXPLORATION
                ,new int[]{R.drawable.palm_0}
                ,new LatLng(12.586495, -61.396696)));

        return array;
    }
}
