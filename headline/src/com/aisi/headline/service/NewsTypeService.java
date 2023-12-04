package com.aisi.headline.service;

import com.aisi.headline.pojo.NewsType;

import java.util.List;

public interface NewsTypeService {

    /**
     * 查询所有头条类型信息
     * @return 返回 List<NewsType>
     */
    List<NewsType> findAll();
}
