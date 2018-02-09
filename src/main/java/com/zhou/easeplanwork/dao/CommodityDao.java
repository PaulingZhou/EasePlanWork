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
    @Select("select * from t_commodity A inner join " +
            "(select `commodityid`, max(`commodityversion`) as `commodityversion` from t_commodity " +
            "where `commodityid`=#{id}) B on A.`commodityversion`=B.`commodityversion` " +
            "and A.`commodityid`=B.`commodityid`")
    public List<Commodity> getCurrentCommodityById(@Param("id") int id);

    @Results({
            @Result(property = "uid", column = "commodityid"),
            @Result(property = "version", column = "commodityversion")
    })
    @Select("select * from t_commodity A inner join " +
            "(select `commodityid`, max(`commodityversion`) as `commodityversion` " +
            "from t_commodity group by commodityid) B " +
            "on A.`commodityid`=B.`commodityid` and A.`commodityversion`=B.`commodityversion`")
    public List<Commodity> getAllCurrentCommodity();

}
