package com.ashleymccallum.thebarkinglot.ListView;

public class Credits {
    private String item;
    private String creditInfo;

    public Credits(String item, String creditInfo) {
        this.item = item;
        this.creditInfo = creditInfo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCreditInfo() {
        return creditInfo;
    }

    public void setCreditInfo(String creditInfo) {
        this.creditInfo = creditInfo;
    }
}
