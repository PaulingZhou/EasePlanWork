package com.zhou.easeplanwork.web.controller;

import com.alibaba.fastjson.JSON;
import java.net.URLEncoder;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.ShoppingCart;
import com.zhou.easeplanwork.service.ListService;
import com.zhou.easeplanwork.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCartController {

    @Autowired
    ListService listService;

    @Autowired
    ShowService showService;

    @RequestMapping("/settleAccount")
    public String showSettleAccount(HttpSession httpSession, HttpServletResponse httpResponse) throws UnsupportedEncodingException {
        Map<String, Object> user = (Map<String, Object>)httpSession.getAttribute("user");
        if(user != null) {
            int user_id = (int)user.get("user_id");
            List<ShoppingCart> products = listService.listShoppingCartById(user_id);
            for(ShoppingCart product:products) {
                int commodity_id = product.getId();
                Commodity commodity = showService.getCurrentCommodityById(commodity_id);
                product.setNum(commodity.getCount());
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
}
