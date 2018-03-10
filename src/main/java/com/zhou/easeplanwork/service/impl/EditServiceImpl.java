package com.zhou.easeplanwork.service.impl;

import com.zhou.easeplanwork.dao.CommodityDao;
import com.zhou.easeplanwork.meta.Commodity;
import com.zhou.easeplanwork.service.EditService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditServiceImpl implements EditService{

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public void editCommodity(Commodity commodity, String title, String summary, String image_url, String detail, Integer price) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommodityDao commodityDao = sqlSession.getMapper(CommodityDao.class);
        Commodity commodity1 = commodity;
        commodity1.setTitle(title);
        commodity1.setVersion(commodity.getVersion()+1);
        commodity1.setSummary(summary);
        commodity1.setImage_url(image_url);
        commodity1.setText(detail);
        commodity1.setPrice(price);
        commodityDao.addCommodity(commodity1);
    }

}
