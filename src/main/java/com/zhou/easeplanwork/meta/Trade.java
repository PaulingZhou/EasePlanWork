package com.zhou.easeplanwork.meta;

public class Trade {
    private int batch_id;
    private int id;
    private int commodity_version;
    private int buyer_id;
    private int count;
    private String buyTime;
    private double buyPrice;
    private String title;

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getCommodity_version() {
        return commodity_version;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public int getCount() {
        return count;
    }


    public void setCommodity_version(int commodity_version) {
        this.commodity_version = commodity_version;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
