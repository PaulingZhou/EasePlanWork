package com.zhou.easeplanwork.dao;

import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommodityDao {

    @Insert("insert into t_commodity(commodityid, commodityversion,title) values(#{uid}, #{version}, #{title})")
    public void addCommodity(Commodity commodity);

    @Delete("delete from t_commodity where commodityid=#{uid} and commodityversion=#{version}")
    public void deleteComodity(Commodity commodity);

    @Results({
            @Result(property = "uid", column = "commodityid"),
            @Result(property = "version", column = "commodityversion")
    })
    @Select("select * from t_commodity")
    public List<Commodity> getAllCurrentCommodity();

}
