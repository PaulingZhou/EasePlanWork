package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.service.EditService;
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
        Map user = new HashMap();
        user.put("usertype", 1);
        user.put("username", "seller");
        model.addAttribute("user", user);
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
        int price = Integer.valueOf(price_unForm.replace(",",""));
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
        int price = Integer.valueOf(price_unForm.replace(",",""));
        int commodityId = editService.getCurrentCommodityId();
        editService.publicCommodity(commodityId+1,title,summary,image_url,detail,price);
        Commodity commodity = showService.getCommodityByIdAndVersion(commodityId+1,1);
        Map product = new HashMap();
        if(commodity != null) {
            product.put("id", commodity.getUid());
        }
        model.addAttribute("product", product);
        return "publicSubmit.ftl";
    }
}
