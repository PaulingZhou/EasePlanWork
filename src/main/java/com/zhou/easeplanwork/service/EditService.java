package com.zhou.easeplanwork.service;

import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.Trade;

import java.util.List;

public interface EditService {

    public void editCommodity(Commodity commodity, String title, String summary, String image_url, String detail, double price);

    public void publicCommodity(int commodityId, String title, String summary, String image_url, String detail, double price);

    public void deleteCommodityById(int commodityId);

    public void addTrade(List<Trade> tradeList, int batch_id, int buyer_id);

    public void addToShoppingCart(int user_id, int commodity_id, int count);
}
