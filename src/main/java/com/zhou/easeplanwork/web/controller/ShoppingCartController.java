package com.zhou.easeplanwork.web.controller;

import com.zhou.easeplanwork.dao.ShoppingCartDao;
import com.zhou.easeplanwork.meta.ShoppingCart;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/addToShoppingCart.action")
    public String addToShoppingCart(@RequestParam(value = "user_id") Integer user_id,
                                    @RequestParam(value = "commodity_id") Integer commodity_id,
                                    @Param(value = "count") Integer count) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShoppingCartDao shoppingCartDao = sqlSession.getMapper(ShoppingCartDao.class);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCommodity_id(commodity_id);
        shoppingCart.setUser_id(user_id);
        shoppingCart.setCount(count == null ? 1 : count);
        shoppingCartDao.addToShoppingCart(shoppingCart);
        return "index";
    }
}