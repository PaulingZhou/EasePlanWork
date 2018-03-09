package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.TradeDao;
import com.zhou.easeplanwork.dao.UserDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.Trade;
import com.zhou.easeplanwork.meta.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/test.action")
    public String test() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        return "index";
    }

    @RequestMapping("/testTrade")
    public String testTrade() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TradeDao tradeDao = sqlSession.getMapper(TradeDao.class);
        List<Trade> trades = tradeDao.getTradeInfoByBuyerId(2);
//        Trade trade = new Trade();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date updateDate = new Date();
//        String stamp = simpleDateFormat.format(updateDate);
//        trade.setBuyer_id(1);
//        trade.setCommodity_id(1);
//        trade.setCommodity_version(3);
//        trade.setCount(4);
//        trade.setTime_stamp(stamp);
//        int batch_id = tradeDao.getCurrentBatch();
//        trade.setBatch_id(batch_id+1);
//        tradeDao.addTrade(trade);
        return "index";
    }

}
