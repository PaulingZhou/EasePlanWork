package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.UserDao;
import com.zhou.easeplanwork.meta.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/login")
    public String loginPage() {
        return "login.ftl";
    }

    @RequestMapping("/api/login")
    @ResponseBody
    public Map<String, Object> requestJson(String userName, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserByUsername(userName);
//        System.out.println("database: \nusername: " + user.getUsername() + "\npassword: " + user.getPassword());
//        System.out.println("frontend: \nusername: " + userName + "\npassword: " + password);
        if(user != null && user.getPassword().equals(password)) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        return map;
    }
}
