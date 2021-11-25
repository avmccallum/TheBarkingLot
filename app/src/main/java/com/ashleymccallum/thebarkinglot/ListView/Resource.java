package com.ashleymccallum.thebarkinglot.ListView;

public class Resource {
    private String resourceItem;
    private int resourceImage;
    private String resourceLink;

    public Resource(String resourceItem, int resourceImage, String resourceLink) {
        this.resourceItem = resourceItem;
        this.resourceImage = resourceImage;
        this.resourceLink = resourceLink;
    }

    public Resource(String resourceItem, int resourceImage) {
        this.resourceItem = resourceItem;
        this.resourceImage = resourceImage;
    }

    public String getResourceItem() {
        return resourceItem;
    }

    public void setResourceItem(String resourceItem) {
        this.resourceItem = resourceItem;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public void setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
    }
}
