package com.zhou.easeplanwork.meta;

public class Commodity {
    private int uid;
    private int version;
    private String title;
    private String summary;
    private double price;
    private String stamp;
    private int owener_id;
    private boolean ispermanent;
    private String text;
    private String image_url;

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Commodity() {
    }

    public int getOwener_id() {
        return owener_id;
    }

    public void setOwener_id(int owener_id) {
        this.owener_id = owener_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public boolean isIspermanent() {
        return ispermanent;
    }

    public void setIspermanent(boolean ispermanent) {
        this.ispermanent = ispermanent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "Commodity{" +
                "uid=" + uid +
                ", version=" + version +
                '}';
    }
}
