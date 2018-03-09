package com.zhou.easeplanwork.web.controller;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TradeController {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/addTrade.action")
    public String addTrade() {
        return "index";
    }

}
