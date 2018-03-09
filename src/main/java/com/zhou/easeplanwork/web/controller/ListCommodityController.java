package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ListCommodityController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/listCommodity.action")
    public String doGet(Model model) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        List<Commodity> commodities = commodityDao.getAllCurrentCommodity();
//        for(Commodity commodity : commodities) {
//            System.out.println(commodity);
//        }
        Map user = new HashMap();
        user.put("username","zhou");
        user.put("usertype",0);
        model.addAttribute("listType",1);
        model.addAttribute("CommodityList", commodities);
        return "ListCommodity";
    }

    @RequestMapping("/index")
    public String listCommodity(Model model) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        List<Commodity> commodities = commodityDao.getAllCurrentCommodity();
        model.addAttribute("listType",1);
        model.addAttribute("CommodityList", commodities);
        return "index.ftl";
    }
}
