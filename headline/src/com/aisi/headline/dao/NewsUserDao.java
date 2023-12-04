package com.aisi.headline.dao;

import com.aisi.headline.pojo.NewsUser;

public interface NewsUserDao {

    /**
     *
     * @return
     */
    NewsUser finaByUsername(String username);
}
