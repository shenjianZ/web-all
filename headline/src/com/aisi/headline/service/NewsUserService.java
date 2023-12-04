package com.aisi.headline.service;

import com.aisi.headline.pojo.NewsUser;

public interface NewsUserService {

    /**
     *
     * @param username
     * @return
     */
    NewsUser finaByUsername(String username);
}
