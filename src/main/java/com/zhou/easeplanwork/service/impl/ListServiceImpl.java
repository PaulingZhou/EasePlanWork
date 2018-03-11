package com.zhou.easeplanwork.service.impl;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.TradeDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.Trade;
import com.zhou.easeplanwork.service.ListService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    @Transactional
    public List<Trade> listTrade(int buyer_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TradeDao tradeDao = sqlSession.getMapper(TradeDao.class);
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        List<Trade> buyList = tradeDao.getTradeInfoByBuyerId(buyer_id);
        for(Trade trade: buyList) {
            Commodity commodity = commodityDao.getCommodityByIdAndVersion(trade.getId(), trade.getCommodity_version());
            trade.setBuyPrice(commodity.getPrice());
            trade.setTitle(commodity.getTitle());
        }
        return buyList;
    }

    @Override
    @Transactional
    public List<Commodity> listCommodity() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        List<Commodity> commodities = commodityDao.getAllCurrentCommodity();
        return commodities;
    }

    @Override
    @Transactional
    public Set<Integer> listAllTradeCommodityId() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TradeDao tradeDao = sqlSession.getMapper(TradeDao.class);
        Set<Integer> commodityIds = new HashSet<>();
        List<Trade> tradeList = tradeDao.getAllTrade();
        for(Trade trade:tradeList) {
            commodityIds.add(trade.getId());
        }
        return commodityIds;
    }

    @Override
    @Transactional
    public Set<Integer> listAllTradeCommodityIdByBuyerId(int buyer_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TradeDao tradeDao = sqlSession.getMapper(TradeDao.class);
        Set<Integer> commodityIds = new HashSet<>();
        List<Trade> tradeList = tradeDao.getTradeInfoByBuyerId(buyer_id);
        for(Trade trade:tradeList) {
            commodityIds.add(trade.getId());
        }
        return commodityIds;
    }

    @Override
    @Transactional
    public Set<Integer> listAllCommodityIdByOwnerId(int owner_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        List<Commodity> commodityList = commodityDao.getAllCurrentCommodityByOwnerId(owner_id);
        Set<Integer> commodityIds = new HashSet<>();
        for(Commodity commodity:commodityList) {
            commodityIds.add(commodity.getUid());
        }
        return commodityIds;
    }


}
