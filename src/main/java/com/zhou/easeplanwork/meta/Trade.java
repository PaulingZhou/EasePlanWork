package com.zhou.easeplanwork.meta;

import java.util.Date;

public class Trade {
    private int batch_id;
    private int commodity_id;
    private int commodity_version;
    private int buyer_id;
    private int count;
    private String time_stamp;

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public int getCommodity_version() {
        return commodity_version;
    }

    public void setCommodity_version(int commodity_version) {
        this.commodity_version = commodity_version;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }
}
