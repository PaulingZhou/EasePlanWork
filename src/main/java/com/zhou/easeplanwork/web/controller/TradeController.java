package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.TradeDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.ShowTrade;
import com.zhou.easeplanwork.meta.Trade;
import com.zhou.easeplanwork.service.ListService;
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
//    @Autowired
//    SqlSessionFactory sqlSessionFactory;

    @Autowired
    ListService listService;

    @RequestMapping("/addTrade.action")
    public String addTrade() {
        return "index";
    }

    @RequestMapping("/listTrade")
    public String listTrade(@RequestParam(value = "buyer_id") int buyer_id, Model model) {
        List<ShowTrade> buyListShow = listService.listTrade(buyer_id);
        model.addAttribute("buyList", buyListShow);
        return "account.ftl";
    }

}
