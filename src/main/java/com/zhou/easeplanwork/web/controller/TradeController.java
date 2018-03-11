package com.zhou.easeplanwork.web.controller;

import com.alibaba.fastjson.JSON;
import com.zhou.easeplanwork.meta.Trade;
import com.zhou.easeplanwork.service.EditService;
import com.zhou.easeplanwork.service.ListService;
import com.zhou.easeplanwork.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.util.List;
import java.util.Map;

@Controller
public class TradeController {


    @Autowired
    ListService listService;

    @Autowired
    ShowService showService;

    @Autowired
    EditService editService;

    @RequestMapping("/addTrade.action")
    public String addTrade() {
        return "index";
    }

    @RequestMapping("/account")
    public String listTrade(HttpSession httpSession,Model model) {
        Map<String, Object> user = (Map<String, Object>)httpSession.getAttribute("user");
        int user_id = (int)user.get("user_id");
        List<Trade> buyList = listService.listTrade(user_id);
        model.addAttribute("buyList", buyList);
        return "account.ftl";
    }


    @RequestMapping("/api/buy")
    public String buyFromShoppingCart(HttpServletRequest request,
                                      HttpServletResponse response,
                                      HttpSession httpSession){
        String msg = request.getParameter("data");
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }
        System.out.println(jb.toString());
        List<Trade> tradeList = JSON.parseArray(jb.toString(), Trade.class);
        Map<String, Object> user = (Map<String, Object>)httpSession.getAttribute("user");
        int user_id = (int)user.get("user_id");
        int batch_id = showService.getCurrentTradeBatchId();
        editService.addTrade(tradeList, batch_id+1, user_id);
        return "";
    }

}
