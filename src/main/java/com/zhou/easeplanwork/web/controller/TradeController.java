package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.TradeDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.ShowTrade;
import com.zhou.easeplanwork.meta.Trade;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TradeController {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/addTrade.action")
    public String addTrade() {
        return "index";
    }

    @RequestMapping("/listTrade")
    public String listTrade(@RequestParam(value = "buyer_id") int buyer_id, Model model) {
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
        model.addAttribute("buyList", buyListShow);
        return "account.ftl";
    }

}
