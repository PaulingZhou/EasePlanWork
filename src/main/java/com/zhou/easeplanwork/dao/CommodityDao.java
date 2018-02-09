package com.zhou.easeplanwork.dao;

import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommodityDao {

    @Insert("insert into t_commodity(uid, version, title, summary, price, stamp, " +
            "user_uid, ispermanent, text, picture) values" +
            "(#{uid}, #{version}, #{title}, #{summary}, #{price}, #{stamp}," +
            "#{user_uid}, #{ispermanent}, #{text}, #{picture})")
    public void addCommodity(Commodity commodity);

    @Delete("delete from t_commodity where uid=#{uid} and version=#{version}")
    public void deleteComodity(Commodity commodity);

    @Select("select * from t_commodity A inner join " +
            "(select `uid`, max(`version`) as `version` from t_commodity " +
            "where `uid`=#{uid}) B on A.`version`=B.`version` " +
            "and A.`uid`=B.`uid`")
    public Commodity getCurrentCommodityById(@Param("uid") int uid);

    @Select("select * from t_commodity where `uid`=#{uid} and `version`=#{version}")
    public Commodity getCommodityByIdAndVersion(@Param("uid") int uid, @Param("version") int version);

    @Select("select * from t_commodity A inner join " +
            "(select `uid`, max(`version`) as `version` " +
            "from t_commodity group by uid) B " +
            "on A.`uid`=B.`uid` and A.`version`=B.`version`")
    public List<Commodity> getAllCurrentCommodity();



}
