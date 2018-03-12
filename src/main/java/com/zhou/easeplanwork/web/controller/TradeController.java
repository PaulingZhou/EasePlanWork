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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.util.HashMap;
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
    @ResponseBody
    public Map<String, Object> buyFromShoppingCart(HttpServletRequest request,
                                      HttpSession httpSession){
        StringBuffer jb = new StringBuffer();
        String line;
        Map<String, Object> result = new HashMap<>();
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }
        System.out.println(jb.toString());
        List<Trade> tradeList = JSON.parseArray(jb.toString(), Trade.class);
        Map<String, Object> user = (Map<String, Object>)httpSession.getAttribute("user");
        int user_id = (int)user.get("user_id");
        int batch_id = showService.getCurrentTradeBatchId()+1;
        try {
            editService.addTrade(tradeList, batch_id, user_id);
        } catch (RuntimeException e) {
            System.out.println("库存不足");
            result.put("message", "库存不足");
        }
        List<Trade> tradeList1 = listService.listTradeByBatchId(batch_id);
        int code = tradeList.size() == tradeList1.size() ? 200 : 404;
        result.put("code", code);
        return result;
    }

}
