package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UpdateCommodityController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value = "UpdateCommodity.edit", method = RequestMethod.GET)
    String doEdit(HttpSession httpSession, Model model) {
        Commodity commodity = (Commodity) httpSession.getAttribute("Commodity");
        System.out.println("UpdateCommodity.action: " + commodity);
        model.addAttribute(commodity);
        return "UpdateCommodity";
    }

    @RequestMapping(value = "UpdateCommodity.modify", method = RequestMethod.POST)
    String doModify(@RequestParam(value = "title") String title,
                    @RequestParam(value = "summary") String summary,
                    @RequestParam(value = "price") Double price,
                    @RequestParam(value = "text") String text,
                    HttpSession httpSession, Model model) {
        Commodity oldCommodity = (Commodity) httpSession.getAttribute("Commodity");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity newCommodity = commodityDao.getCurrentCommodityById(oldCommodity.getUid());
        newCommodity.setVersion(newCommodity.getVersion()+1);
        newCommodity.setTitle(title);
        newCommodity.setSummary(summary);
        newCommodity.setPrice(price);
        newCommodity.setText(text);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date updateDate = new Date();
        String stamp = simpleDateFormat.format(updateDate);
        newCommodity.setStamp(stamp);
        commodityDao.addCommodity(newCommodity);
        return "redirect:/commodityDetail.action?id="+newCommodity.getUid();
    }
}
