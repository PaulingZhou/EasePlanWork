package com.zhou.easeplanwork.service.impl;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.TradeDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.ShowTrade;
import com.zhou.easeplanwork.meta.Trade;
import com.zhou.easeplanwork.service.ListService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public List<ShowTrade> listTrade(int buyer_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TradeDao tradeDao = sqlSession.getMapper(TradeDao.class);
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        List<Trade> buyList = tradeDao.getTradeInfoByBuyerId(buyer_id);
        List<ShowTrade> buyListShow = new ArrayList<>();
        for(Trade trade: buyList) {
            ShowTrade trade1 = new ShowTrade(trade);
            Commodity commodity = commodityDao.getCommodityByIdAndVersion(trade.getCommodity_id(), trade.getCommodity_version());
            trade1.setBuyPrice(commodity.getPrice());
            trade1.setTitle(commodity.getTitle());
            buyListShow.add(trade1);
        }
        return buyListShow;
    }

    @Override
    public List<Commodity> listCommodity() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        List<Commodity> commodities = commodityDao.getAllCurrentCommodity();
        return commodities;
    }
}