package com.zhou.easeplanwork.dao;

import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface CommodityDao {

    @Insert("insert into t_commodity(commodityid, commodityversion,title) values(#{uid}, #{version}, #{title})")
    public void addCommodity(Commodity commodity);

    @Delete("delete from t_commodity where commodityid=#{uid} and commodityversion=#{version}")
    public void deleteComodity(Commodity commodity);

}
