package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CommodityDetailsController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value = "commodity/{id}", method = RequestMethod.GET)
    public String commodityGet(@PathVariable(value = "id") Integer id,
                               Model model) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity = commodityDao.getCurrentCommodityById(id);
        model.addAttribute("model", model);
        Map user = new HashMap();
        user.put("username", "Pauling");
        user.put("usertype", 1);
        Map product = new HashMap();
        product.put("id", commodity.getUid());
        product.put("title", commodity.getTitle());
        product.put("summary", commodity.getSummary());
        product.put("detail", commodity.getText());
        product.put("image_url", commodity.getImage_url());
        product.put("price", commodity.getPrice());
        model.addAttribute("user", user);
        model.addAttribute("product", product);
        return "edit.ftl";
    }

}
