package com.astra.discoversv.Items;

public class QuickHorizontalCard  {

    private int image;
    private String description;

    public QuickHorizontalCard() {
    }

    public QuickHorizontalCard(int image, String description) {
        this.image = image;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
