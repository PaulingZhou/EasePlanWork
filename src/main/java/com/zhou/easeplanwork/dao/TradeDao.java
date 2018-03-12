package com.zhou.easeplanwork.dao;

import com.zhou.easeplanwork.meta.Trade;

import java.util.List;
import java.util.Set;

public interface TradeDao {

    public Boolean addTrade(Trade trade);
    public int getCurrentBatchId();
    List<Trade> getTradeInfoByBuyerId(int buyer_id);
    List<Trade> getAllTrade();
    List<Trade> getTradeInfoByBatchId(int batch_id);

}
