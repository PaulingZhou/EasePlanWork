package com.zhou.easeplanwork.service;

import com.zhou.easeplanwork.meta.Commodity;

public interface EditService {

    public void editCommodity(Commodity commodity, String title, String summary, String image_url, String detail, Integer price);

    public void publicCommodity(int commodityId, String title, String summary, String image_url, String detail, Integer price);

    public int getCurrentCommodityId();
}
