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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommodityDetailsController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/commodityDetail.action")
    public String doGet(@RequestParam("id") Integer id,
                        @Param("version") Integer version,
                        @Param("getpicture") Boolean getpicture,
                        Model model) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity = version == null || version <= 0 ? commodityDao.getCurrentCommodityById(id) : commodityDao.getCommodityByIdAndVersion(id, version);
        model.addAttribute("Commodity", commodity);
        if (getpicture != null && getpicture == true) {
            return "CommodityPicture";
        } else {
            return "edit.ftl";
        }
    }

}
