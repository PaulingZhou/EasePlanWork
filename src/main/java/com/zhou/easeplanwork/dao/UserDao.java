package com.zhou.easeplanwork.dao;

import com.zhou.easeplanwork.meta.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Results({
        @Result(property = "id", column = "uid"),
        @Result(property = "username", column = "username")
    })
    @Select("select * from t_user where uid=#{id}")
    public User findUserById(int id);

    public User findUserByUsername(String username);
}
