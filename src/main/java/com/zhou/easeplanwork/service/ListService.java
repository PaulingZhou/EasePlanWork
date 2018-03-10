package com.zhou.easeplanwork.service;

import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.ShowTrade;

import java.util.List;

public interface ListService {
    public List<ShowTrade> listTrade(int buyer_id);
    public List<Commodity> listCommodity();
}
