package com.aisi.headline.service.impl;

import com.aisi.headline.dao.NewsUserDao;
import com.aisi.headline.dao.impl.NewUserDaoImpl;
import com.aisi.headline.pojo.NewsUser;
import com.aisi.headline.service.NewsUserService;
import com.aisi.headline.util.MD5Util;

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

    /**
     * @param userId
     * @return
     */
    @Override
    public NewsUser findByUid(Integer userId) {
        return userDao.finByUid(userId);
    }

    /**
     * @param registUser
     * @return
     */
    @Override
    public int registUser(NewsUser registUser) {
        String encrypt = MD5Util.encrypt(registUser.getUserPwd());
        registUser.setUserPwd(encrypt);
        return userDao.insertUser(registUser);
    }
}
