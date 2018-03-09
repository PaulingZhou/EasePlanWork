package com.zhou.easeplanwork.dao;

import com.zhou.easeplanwork.meta.Trade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradeDao {

    public Boolean addTrade(Trade trade);
    public int getCurrentBatch();
    List<Trade> getTradeInfoByBuyerId(int buyer_id);

}
