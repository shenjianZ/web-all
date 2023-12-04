package com.aisi.headline.dao;

import com.aisi.headline.pojo.NewsType;

import java.util.List;

public interface NewsTypeDao {

    /**
     * 查询所有头条类型信息
     * @return
     */
    List<NewsType> findAll();
}
