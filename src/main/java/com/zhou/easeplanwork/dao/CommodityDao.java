package com.zhou.easeplanwork.dao;

import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommodityDao {

    public void addCommodity(Commodity commodity);

    public void deleteComodity(Commodity commodity);

    public Commodity getCurrentCommodityById(@Param("uid") int uid);

    public Commodity getCommodityByIdAndVersion(@Param("uid") int uid, @Param("version") int version);

    public List<Commodity> getAllCurrentCommodity();

    public Integer getCurrentCommodityId();

    public List<Commodity> getAllCurrentCommodityByOwnerId(int owner_id);

}
