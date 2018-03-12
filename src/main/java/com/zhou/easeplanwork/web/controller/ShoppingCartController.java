package com.zhou.easeplanwork.web.controller;

import com.alibaba.fastjson.JSON;

import java.net.URLEncoder;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.ShoppingCart;
import com.zhou.easeplanwork.service.EditService;
import com.zhou.easeplanwork.service.ListService;
import com.zhou.easeplanwork.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCartController {

    @Autowired
    ListService listService;

    @Autowired
    ShowService showService;

    @Autowired
    EditService editService;

    @RequestMapping("/settleAccount")
    public String showSettleAccount(HttpSession httpSession, HttpServletResponse httpResponse) throws UnsupportedEncodingException {
        Map<String, Object> user = (Map<String, Object>)httpSession.getAttribute("user");
        if(user != null) {
            int user_id = (int)user.get("user_id");
            List<ShoppingCart> products = listService.listShoppingCartById(user_id);
            for(ShoppingCart product:products) {
                int commodity_id = product.getId();
                Commodity commodity = showService.getCurrentCommodityById(commodity_id);
                product.setTitle(commodity.getTitle());
                product.setPrice(commodity.getPrice());
            }
            String jsonMsg = JSON.toJSONString(products);
            jsonMsg = URLEncoder.encode(jsonMsg,"utf-8");
            Cookie cookie = new Cookie("products", jsonMsg);
            httpResponse.addCookie(cookie);
        }
        return "settleAccount.ftl";
    }

    @RequestMapping("/api/addSettleAccount")
    @ResponseBody
    public Map<String, Object> addProductToShoppingCart(HttpSession httpSession,
                                                        @RequestParam(value = "id") Integer id) {
        Map<String, Object> responseMap = new HashMap<>();
        Map<String, Object> user = (Map<String, Object>)httpSession.getAttribute("user");
        int user_id = (int)user.get("user_id");
        editService.addToShoppingCart(user_id, id, 1);
        responseMap.put("code", 200);
        return responseMap;
    }


}
