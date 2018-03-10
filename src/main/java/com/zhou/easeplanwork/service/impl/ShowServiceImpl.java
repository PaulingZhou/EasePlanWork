package com.zhou.easeplanwork.service.impl;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.service.ShowService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl implements ShowService{

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public Commodity getCurrentCommodityById(int commodity_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity = commodityDao.getCurrentCommodityById(commodity_id);
        return commodity;
    }

    @Override
    public Commodity getCommodityByIdAndVersion(int commodity_id, int commodity_version) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity = commodityDao.getCommodityByIdAndVersion(commodity_id, commodity_version);
        return commodity;
    }
}
