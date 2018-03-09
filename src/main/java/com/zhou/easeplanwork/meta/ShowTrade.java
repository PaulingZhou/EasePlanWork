package com.zhou.easeplanwork.meta;

public class ShowTrade {
    private final int id;
    private final int commodity_version;
    private final int buyer_id;
    private final int count;
    private final String buyTime;
    private double buyPrice;
    private String title;

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

    public int getId() {
        return id;
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

    public String getBuyTime() {
        return buyTime;
    }

    public ShowTrade(Trade trade) {
        this.id = trade.getCommodity_id();
        this.commodity_version = trade.getCommodity_version();
        this.buyer_id = trade.getBuyer_id();
        this.count = trade.getCount();
        this.buyTime = trade.getTime_stamp();
    }
}
