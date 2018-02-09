package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.dao.UserDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.meta.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/test.action")
    public String test() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        return "index";
    }
}
