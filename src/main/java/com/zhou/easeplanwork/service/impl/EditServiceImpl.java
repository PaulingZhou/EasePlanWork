package com.zhou.easeplanwork.service.impl;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.TradeDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.Trade;
import com.zhou.easeplanwork.service.EditService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EditServiceImpl implements EditService{

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    @Transactional
    public void editCommodity(Commodity commodity, String title, String summary, String image_url, String detail, double price) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity1 = commodity;
        commodity1.setTitle(title);
        commodity1.setVersion(commodity.getVersion()+1);
        commodity1.setSummary(summary);
        commodity1.setImage_url(image_url);
        commodity1.setText(detail);
        commodity1.setPrice(price);
        commodityDao.addCommodity(commodity1);
    }

    @Override
    @Transactional
    public void publicCommodity(int commodityId, String title, String summary, String image_url, String detail, double price) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity = new Commodity();
        commodity.setTitle(title);
        commodity.setVersion(1);
        commodity.setSummary(summary);
        commodity.setImage_url(image_url);
        commodity.setText(detail);
        commodity.setPrice(price);
        commodity.setOwner_uid(2);
        commodity.setCount(1);
        commodity.setUid(commodityId);
        commodityDao.addCommodity(commodity);
    }



    @Override
    @Transactional
    public void deleteCommodityById(int commodityId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        commodityDao.deleteCommodityById(commodityId);
    }

    @Override
    @Transactional
    public void addTrade(List<Trade> tradeList, int batch_id, int buyer_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        TradeDao tradeDao = sqlSession.getMapper(TradeDao.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date updateDate = new Date();
        String stamp = simpleDateFormat.format(updateDate);
        for(Trade trade:tradeList) {
            Commodity commodity = commodityDao.getCurrentCommodityById(trade.getId());
            trade.setBatch_id(batch_id);
            trade.setCommodity_version(commodity.getVersion());
            trade.setBuyer_id(buyer_id);
            trade.setBuyTime(stamp);
            trade.setBuyPrice(commodity.getPrice());
            trade.setTitle(commodity.getTitle());
            trade.setImage_url(commodity.getImage_url());
            tradeDao.addTrade(trade);
        }
    }

}
