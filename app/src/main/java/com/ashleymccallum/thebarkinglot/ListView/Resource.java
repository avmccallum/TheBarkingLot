package com.ashleymccallum.thebarkinglot.ListView;

public class Resource {
    private String item;
    private int image;

    public Resource(String item, int image) {
        this.item = item;
        this.image = image;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
