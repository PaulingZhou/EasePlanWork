package com.zhou.easeplanwork.meta;

public class Commodity {
    private int uid;
    private int version;
    private String title;
    private String summary;
    private double price;
    private int owner_uid;
    private boolean ispermanent;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

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

    public int getOwner_uid() {
        return owner_uid;
    }

    public void setOwner_uid(int owner_uid) {
        this.owner_uid = owner_uid;
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
