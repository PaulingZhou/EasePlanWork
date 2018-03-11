package com.zhou.easeplanwork.service.impl;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.TradeDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.service.ShowService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShowServiceImpl implements ShowService{

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    @Transactional
    public Commodity getCurrentCommodityById(int commodity_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity = commodityDao.getCurrentCommodityById(commodity_id);
        return commodity;
    }

    @Override
    @Transactional
    public Commodity getCommodityByIdAndVersion(int commodity_id, int commodity_version) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity = commodityDao.getCommodityByIdAndVersion(commodity_id, commodity_version);
        return commodity;
    }

    @Override
    @Transactional
    public int getCurrentCommodityId() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        return commodityDao.getCurrentCommodityId();
    }

    @Override
    @Transactional
    public int getCurrentTradeBatchId() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TradeDao tradeDao = sqlSession.getMapper(TradeDao.class);
        return tradeDao.getCurrentBatchId();
    }


}
