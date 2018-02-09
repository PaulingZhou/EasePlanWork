package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ListCommodityController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/listCommodity.action")
    public String doGet(@Param("id") Integer id,
            Model model) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        List<Commodity> commodities = commodityDao.getCurrentCommodityById(id);
        for(Commodity commodity : commodities) {
            System.out.println(commodity);
        }
        model.addAttribute("CommodityList", commodities);
        return "ListCommodity";
    }
}
