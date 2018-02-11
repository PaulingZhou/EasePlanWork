package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.meta.Commodity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UpdateCommodityController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value = "updateCommodity.edit", method = RequestMethod.GET)
    String doEdit(HttpSession httpSession, Model model) {
        Commodity commodity = (Commodity) httpSession.getAttribute("Commodity");
        System.out.println("UpdateCommodity.action: " + commodity);
        model.addAttribute(commodity);
        return "UpdateCommodity";
    }

    @RequestMapping(value = "updateCommodity.modify", method = RequestMethod.POST)
    String doModify(@RequestParam(value = "title") String title,
                    @RequestParam(value = "summary") String summary,
                    @RequestParam(value = "price") Double price,
                    @RequestParam(value = "text") String text,
                    HttpSession httpSession) {
        Commodity oldCommodity = (Commodity) httpSession.getAttribute("Commodity");

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity newCommodity = commodityDao.getCurrentCommodityById(oldCommodity.getUid());
        newCommodity.setVersion(newCommodity.getVersion()+1);
        newCommodity.setTitle(title);
        newCommodity.setSummary(summary);
        newCommodity.setPrice(price);
        newCommodity.setText(text);
        //upload picture
        MultipartFile picture = (MultipartFile) httpSession.getAttribute("picture");
        if(picture != null) {
            try {
                byte[] pictureByte = picture.getBytes();
                newCommodity.setPicture(pictureByte);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date updateDate = new Date();
        String stamp = simpleDateFormat.format(updateDate);
        newCommodity.setStamp(stamp);
        commodityDao.addCommodity(newCommodity);

        return "redirect:/commodityDetail.action?id="+newCommodity.getUid();
    }

    @RequestMapping(value = "updateCommodity.updatePicture", method = RequestMethod.POST)
    String doUpdatePicture(@RequestParam(value = "picture")MultipartFile picture, ModelMap modelMap, HttpSession httpSession) {
        System.out.println(picture);
        modelMap.addAttribute("picture", picture);
        httpSession.setAttribute("picture", picture);
        String filename = picture.getName();
        String originFilename = picture.getOriginalFilename();
        String contentType = picture.getContentType();
        try {
            byte bytes[] = picture.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "UpdateCommodity";
    }
}
