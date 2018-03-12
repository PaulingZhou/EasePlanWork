package com.zhou.easeplanwork.dao;

import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommodityDao {

    public void addCommodity(Commodity commodity);

    public void deleteCommodity(Commodity commodity);

    public void deleteCommodityById(int id);

    public Commodity getCurrentCommodityById(@Param("uid") int uid);

    public Commodity getCommodityByIdAndVersion(@Param("uid") int uid, @Param("version") int version);

    public List<Commodity> getAllCurrentCommodity();

    public Integer getCurrentCommodityId();

    public List<Commodity> getAllCurrentCommodityByOwnerId(int owner_id);

    public void updateCount(@Param("commodity_id") int commodity_id, @Param("commodity_version")int commodity_version, @Param("count")int count);

}
