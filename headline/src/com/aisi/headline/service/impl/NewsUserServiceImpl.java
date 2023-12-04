package com.aisi.headline.service.impl;

import com.aisi.headline.dao.NewsUserDao;
import com.aisi.headline.dao.impl.NewUserDaoImpl;
import com.aisi.headline.pojo.NewsUser;
import com.aisi.headline.service.NewsUserService;

public class NewsUserServiceImpl implements NewsUserService {

    private NewsUserDao  userDao= new NewUserDaoImpl();
    /**
     * @param username
     * @return
     */
    @Override
    public NewsUser finaByUsername(String username) {
         return userDao.finaByUsername(username);
    }
}
