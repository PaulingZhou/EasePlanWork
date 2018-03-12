package com.zhou.easeplanwork.service.impl;

import com.zhou.easeplanwork.dao.UserDao;
import com.zhou.easeplanwork.meta.User;
import com.zhou.easeplanwork.service.LoginService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    @Transactional
    public User login(String userName, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserByUsername(userName);
        if(user != null && user.getPassword().equals(password))
            return user;
        else return null;
    }
}
