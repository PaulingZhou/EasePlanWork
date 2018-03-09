package com.zhou.easeplanwork.dao;


import com.zhou.easeplanwork.meta.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartDao {
    public Boolean addToShoppingCart(ShoppingCart shoppingCart);
    List<ShoppingCart> getShoppingCart(@Param("user_id") Integer user_id);
}
