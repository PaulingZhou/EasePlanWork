package com.zhou.easeplanwork.meta;

public class Commodity {
    private int uid;
    private int version;
    private String title;
    private String summary;
    private String price;
    private String stamp;
    private int user_uid;
    private boolean ispermanent;

    public Commodity() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public int getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(int user_uid) {
        this.user_uid = user_uid;
    }

    public boolean isIspermanent() {
        return ispermanent;
    }

    public void setIspermanent(boolean ispermanent) {
        this.ispermanent = ispermanent;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "uid=" + uid +
                ", version=" + version +
                '}';
    }
}
