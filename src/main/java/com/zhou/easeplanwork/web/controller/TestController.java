package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.UserDao;
import com.zhou.easeplanwork.meta.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/test.action")
    public String test() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user1 = userDao.findUserById(2);
        User user2 = userDao.findUserByUsername("buyer");
        System.out.println("username:" + user1.getUsername() + ", id: " + user1.getId());
        System.out.println("username:" + user2.getUsername() + ", id: " + user2.getId());
        return "index";
    }
}
