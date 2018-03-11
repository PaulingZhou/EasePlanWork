package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.service.EditService;
import com.zhou.easeplanwork.service.ListService;
import com.zhou.easeplanwork.service.ShowService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CommodityController {

    @Autowired
    ShowService showService;

    @Autowired
    ListService listService;

    @Autowired
    EditService editService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showCommodity(@RequestParam(value = "id") Integer id,
                                Model model) {
        Commodity commodity = showService.getCurrentCommodityById(id);
        Map product = new HashMap();
        product.put("id", commodity.getUid());
        product.put("title", commodity.getTitle());
        product.put("summary", commodity.getSummary());
        product.put("detail", commodity.getText());
        product.put("image_url", commodity.getImage_url());
        product.put("isBuy", false);
        product.put("price", commodity.getPrice());
        model.addAttribute("product", product);
        return "show.ftl";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listCommodity(HttpSession httpSession, Model model) {
        List<Commodity> commodities = listService.listCommodity();
        Map<String, Object> user = (Map<String, Object>)httpSession.getAttribute("user");
        if(user != null) {
            int user_id = (int)user.get("user_id");
            int user_type = (int) user.get("usertype");
            if(user_type == 0) {
                Set<Integer> buy_set = listService.listAllTradeCommodityIdByBuyerId(user_id);
                for(Commodity commodity: commodities) {
                    commodity.setBuy(buy_set.contains(commodity.getUid()));
                }
            } else if(user_type == 1) {
                Set<Integer> trade_commodity_id = listService.listAllTradeCommodityId();
                Set<Integer> commodity_id_from_ownerid = listService.listAllCommodityIdByOwnerId(user_id);
                Set<Integer> sell_set = trade_commodity_id;
                sell_set.retainAll(commodity_id_from_ownerid);
                for(Commodity commodity: commodities) {
                    commodity.setSell(sell_set.contains(commodity.getUid()));
                }
            }
        }
        model.addAttribute("CommodityList", commodities);
        return "index.ftl";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCommodity(@RequestParam(value = "id") Integer id,
                                Model model) {
        Commodity commodity = showService.getCurrentCommodityById(id);
        Map product = new HashMap();
        product.put("id", commodity.getUid());
        product.put("title", commodity.getTitle());
        product.put("summary", commodity.getSummary());
        product.put("detail", commodity.getText());
        product.put("image_url", commodity.getImage_url());
        product.put("isBuy", false);
        product.put("price", commodity.getPrice());
        model.addAttribute("product", product);
        return "edit.ftl";
    }

    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String submitEditCommodity(@RequestParam(value = "id") Integer id,
                                      @RequestParam(value = "title") String title,
                                      @RequestParam(value = "summary") String summary,
                                      @RequestParam(value = "image") String image_url,
                                      @RequestParam(value = "detail") String detail,
                                      @RequestParam(value = "price") String price_unForm,
                                      Model model) {
        Commodity commodity = showService.getCurrentCommodityById(id);
        int version = commodity.getVersion();
        double price = Double.valueOf(price_unForm.replace(",",""));
        editService.editCommodity(commodity, title, summary, image_url, detail, price);
        Commodity newCommodity = showService.getCommodityByIdAndVersion(id, version);
        Map product = new HashMap();
        if(newCommodity != null) {
            product.put("id", newCommodity.getUid());
        }
        model.addAttribute("product", product);
        return "editSubmit.ftl";
    }

    @RequestMapping(value = "/public")
    public String publicCommodity(Model model) {
        return "public.ftl";
    }

    @RequestMapping(value = "/publicSubmit", method = RequestMethod.POST)
    public String submitPublicCommodity(@RequestParam(value = "title") String title,
                                        @RequestParam(value = "summary") String summary,
                                        @RequestParam(value = "image") String image_url,
                                        @RequestParam(value = "detail") String detail,
                                        @RequestParam(value = "price") String price_unForm,
                                        Model model) {
        double price = Double.valueOf(price_unForm.replace(",",""));
        int commodityId = showService.getCurrentCommodityId();
        editService.publicCommodity(commodityId+1,title,summary,image_url,detail,price);
        Commodity commodity = showService.getCommodityByIdAndVersion(commodityId+1,1);
        Map product = new HashMap();
        if(commodity != null) {
            product.put("id", commodity.getUid());
        }
        model.addAttribute("product", product);
        return "publicSubmit.ftl";
    }

    @RequestMapping(value = "/api/delete")
    @ResponseBody
    public Map<String, Object> deleteCommodity(@Param(value = "id") Integer id) {
        Map resultMap = new HashMap();
        editService.deleteCommodityById(id);
        Commodity commodity = showService.getCurrentCommodityById(id);
        if(commodity == null) {
            resultMap.put("code",200);
        } else {
            resultMap.put("code", 403);
        }
        return resultMap;
    }
}
