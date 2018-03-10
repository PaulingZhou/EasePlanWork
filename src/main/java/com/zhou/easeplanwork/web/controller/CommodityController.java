package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.service.ListService;
import com.zhou.easeplanwork.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommodityController {

    @Autowired
    ShowService showService;

    @Autowired
    ListService listService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showCommodity(@RequestParam(value = "id") Integer id,
                                Model model) {
        Commodity commodity = showService.getCommodityById(id);
        Map product = new HashMap();
        product.put("id", commodity.getUid());
        product.put("title", commodity.getTitle());
        product.put("summary", commodity.getSummary());
        product.put("detail", commodity.getText());
        product.put("image_url", commodity.getImage_url());
        product.put("isBuy", false);
        product.put("price", commodity.getPrice());
        Map user = new HashMap();
        user.put("usertype", 0);
        user.put("username", "buyer");
        model.addAttribute("user", user);
        model.addAttribute("product", product);
        return "show.ftl";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listCommodity(Model model) {
        List<Commodity> commodities = listService.listCommodity();
        model.addAttribute("listType",1);
        model.addAttribute("CommodityList", commodities);
        return "index.ftl";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editCommodity(@RequestParam(value = "id") Integer id,
                                Model model) {
        Commodity commodity = showService.getCommodityById(id);
        Map product = new HashMap();
        product.put("id", commodity.getUid());
        product.put("title", commodity.getTitle());
        product.put("summary", commodity.getSummary());
        product.put("detail", commodity.getText());
        product.put("image_url", commodity.getImage_url());
        product.put("isBuy", false);
        product.put("price", commodity.getPrice());
        Map user = new HashMap();
        user.put("usertype", 1);
        user.put("username", "seller");
        model.addAttribute("user", user);
        model.addAttribute("product", product);
        return "edit.ftl";
    }
}
