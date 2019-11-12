package com.astra.discoversv.Items;

import android.provider.ContactsContract;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String name, address, type, number, description;



    public Contact(String name, String address, String type, String number, String description) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.number = number;
        this.description = description;
    }

    public Contact(String name, String address, String type, String number) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.number = number;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Contact> initContacts(String type){

        List<Contact> contacts = new ArrayList<>();

        // --- GENERAL ---
        contacts.add(new Contact("Ministry of Tourism",
                "Kingstown",
                "general",
                "1784451502"));
        contacts.add(new Contact("Argyle International Airport",
                "Argyle",
                "general",
                "17844565555"));
        contacts.add(new Contact("Cruise Ship Terminal",
                "Kingstown",
                "general",
                "17844561830"));
        contacts.add(new Contact("Police",
                "Kingstown",
                "general",
                "1784571211"));
        contacts.add(new Contact("Hospital",
                "Lodge Village",
                "general",
                "17844572586"));



        // ------ TAXI ----
        contacts.add(new Contact("John T. Burgess",
                "Lodge Village",
                "taxi",
                "17841234567",
                "4"));
        contacts.add(new Contact("Kathleen S. Shirley",
                "Edinboro",
                "taxi",
                "17841234567",
                "4"));
        contacts.add(new Contact("Michael E. Obrien",
                "Cane Garden",
                "taxi",
                "17841234567",
                "6"));
        contacts.add(new Contact("Keith T. Sanderson",
                "Sharpes",
                "taxi",
                "17841234567",
                "4"));
        contacts.add(new Contact("Kelly F. Carolina",
                "Sharpes",
                "taxi",
                "17841234567",
                "6"));
        contacts.add(new Contact("Darrell J. Smith",
                "Green Hill",
                "taxi",
                "17841234567",
                "10"));
        contacts.add(new Contact("Ricardo L. Hedden",
                "Old Montrose",
                "taxi",
                "17841234567",
                "6"));
        contacts.add(new Contact("Anthony S. Rollin",
                "Sharpes",
                "taxi",
                "17841234567",
                "4"));
        contacts.add(new Contact("Rocco M. Gonzales",
                "Sion Hill",
                "taxi",
                "17841234567",
                "4"));
        contacts.add(new Contact("Ron S. Coleman",
                "Clare Valley",
                "taxi",
                "17841234567",
                "6"));

        // ------ TOURS ----
        contacts.add(new Contact("Hazeco Tours",
                "Gunn Hill",
                "tour",
                "17844578634"));

        contacts.add(new Contact("Going Places Travel",
                "Bequia",
                "tour",
                "17844583062"));

        contacts.add(new Contact("Fantasea Tours",
                "Villa Beach",
                "tour",
                "17844574477"));
        contacts.add(new Contact("Sailor's Wilderness Tours",
                "Kingstown",
                "tour",
                "7844571712"));

        contacts.add(new Contact("Serenity Dive",
                "Ratho Mill",
                "tour",
                "7844575335"));

        contacts.add(new Contact("Dive Bequia",
                "Port Elizabeth",
                "tour",
                "7844583504"));

        List<Contact> filtered = new ArrayList<>();

        for (Contact contact : contacts){
            if (contact.getType() == type){
                filtered.add(contact);
            }
        }

        return filtered;

    };

}
