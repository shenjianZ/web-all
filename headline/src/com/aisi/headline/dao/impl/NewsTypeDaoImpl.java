package com.aisi.headline.dao.impl;

import com.aisi.headline.dao.BaseDao;
import com.aisi.headline.dao.NewsTypeDao;
import com.aisi.headline.pojo.NewsType;

import java.util.List;

public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {

    /**
     * 查询所有头条类型信息
     *
     * @return
     */
    @Override
    public List<NewsType> findAll() {
        String sql = " select tid,tname from news_type ;";
        List<NewsType> typeList = baseQuery(NewsType.class, sql);
        return typeList;
    }
}
