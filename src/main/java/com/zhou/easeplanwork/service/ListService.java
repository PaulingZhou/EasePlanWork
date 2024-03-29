package com.zhou.easeplanwork.service;

import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.ShoppingCart;
import com.zhou.easeplanwork.meta.Trade;

import java.util.List;
import java.util.Set;

public interface ListService {
    public List<Trade> listTradeByBatchId(int batch_id);
    public List<Trade> listTrade(int buyer_id);
    public List<Commodity> listCommodity();
    public Set<Integer> listAllTradeCommodityId();
    public Set<Integer> listAllTradeCommodityIdByBuyerId(int buyer_id);
    public Set<Integer> listAllCommodityIdByOwnerId(int owner_id);
    public List<ShoppingCart> listShoppingCartById(int user_id);
}
