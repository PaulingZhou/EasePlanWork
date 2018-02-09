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

@Controller
public class CommodityDetailsController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/commodityDetail.action")
    public String doGet(@Param("id") Integer id,
                        @Param("version") Integer version,
                        Model model) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity = version <= 0 ? commodityDao.getCurrentCommodityById(id) : commodityDao.getCommodityByIdAndVersion(id, version);
        model.addAttribute("Commodity", commodity);
        return "CommodityDetails";
    }

}
