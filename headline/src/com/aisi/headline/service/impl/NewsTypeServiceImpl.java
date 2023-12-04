package com.aisi.headline.service.impl;

import com.aisi.headline.dao.NewsTypeDao;
import com.aisi.headline.dao.impl.NewsTypeDaoImpl;
import com.aisi.headline.pojo.NewsType;
import com.aisi.headline.service.NewsTypeService;

import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {

    private NewsTypeDao typeDao = new NewsTypeDaoImpl();

    /**
     * 查询所有头条类型信息
     *
     * @return 返回 List<NewsType>
     */
    @Override
    public List<NewsType> findAll() {
        return typeDao.findAll();
    }
}
