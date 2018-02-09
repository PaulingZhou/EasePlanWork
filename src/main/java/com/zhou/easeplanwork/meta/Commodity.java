package com.zhou.easeplanwork.meta;

public class Commodity {
    private int uid;
    private int version;
    private String title;

    public Commodity(int uid, int version, String title) {
        this.uid = uid;
        this.version = version;
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
