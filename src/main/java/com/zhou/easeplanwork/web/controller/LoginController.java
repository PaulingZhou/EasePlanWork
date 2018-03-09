package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.UserDao;
import com.zhou.easeplanwork.meta.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    public Map<String, Object> requestJson(String userName, String password, HttpSession httpSession) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserByUsername(userName);
        Map<String, Object> map = new HashMap<>();
        if(user != null && user.getPassword().equals(password)) {
            System.out.println("success");
            Map userMap = new HashMap();
            userMap.put("username", user.getUsername());
            userMap.put("usertype", user.getUsertype());
            httpSession.setAttribute("user", userMap);
        } else {
            System.out.println("fail");
        }
        map.put("code", 200);
        return map;
    }
}
