package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.meta.User;
import com.zhou.easeplanwork.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String loginPage() {
        return "login.ftl";
    }

    @RequestMapping("/api/login")
    @ResponseBody
    public Map<String, Object> login(String userName, String password, HttpSession httpSession) {
        User user = loginService.login(userName, password);
        Map<String, Object> map = new HashMap<>();
        if(user != null) {
            Map userMap = new HashMap();
            userMap.put("username", user.getUsername());
            userMap.put("user_id", user.getUid());
            userMap.put("usertype", user.getUsertype());
            httpSession.setAttribute("user", userMap);
            map.put("code", 200);
        } else {
            map.put("code", 403);
        }
        return map;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        if(httpSession.getAttribute("user") != null) {
            httpSession.removeAttribute("user");
        }
        return "redirect:/login";
    }
}
