package com.aisi.headline.dao;

import com.aisi.headline.pojo.NewsUser;

public interface NewsUserDao {

    /**
     *
     * @return
     */
    NewsUser finaByUsername(String username);

    /**
     *
     * @param userId
     * @return
     */
    NewsUser finByUid(Integer userId);

    /**
     *
     * @param registUser
     * @return
     */
    int insertUser(NewsUser registUser);
}
