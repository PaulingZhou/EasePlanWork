package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.meta.Trade;
import com.zhou.easeplanwork.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class TradeController {


    @Autowired
    ListService listService;

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

}
