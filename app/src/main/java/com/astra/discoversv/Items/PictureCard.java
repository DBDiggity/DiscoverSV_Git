package com.astra.discoversv.Items;

public class PictureCard {

    private String name;
    private int background;

    public PictureCard() {
    }

    public PictureCard(String name, int background) {
        this.name = name;
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }



}
