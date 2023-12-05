package com.aisi.headline.service;

import com.aisi.headline.pojo.NewsUser;

public interface NewsUserService {

    /**
     *
     * @param username
     * @return
     */
    NewsUser finaByUsername(String username);

    /**
     *
     * @param userId
     * @return
     */
    NewsUser findByUid(Integer userId);

    /**
     *
     * @param registUser
     * @return
     */
    int registUser(NewsUser registUser);
}
