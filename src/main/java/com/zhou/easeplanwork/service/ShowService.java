package com.zhou.easeplanwork.service;

import com.zhou.easeplanwork.meta.Commodity;

public interface ShowService {

    public Commodity getCurrentCommodityById(int commodity_id);

    public Commodity getCommodityByIdAndVersion(int commodity_id, int commodity_version);

    public int getCurrentCommodityId();

    public int getCurrentTradeBatchId();

}
