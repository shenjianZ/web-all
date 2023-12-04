package com.aisi.headline.dao.impl;

import com.aisi.headline.dao.BaseDao;

import com.aisi.headline.dao.NewsUserDao;
import com.aisi.headline.pojo.NewsUser;

import java.util.List;

public class NewUserDaoImpl extends BaseDao implements NewsUserDao {

    /**
     *
     * @return
     */
    @Override
    public NewsUser finaByUsername(String username) {
        String sql = "select uid, username, user_pwd as userPwd, nick_name as nickName from news_user where username = ?";
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, username);
        if(!(newsUserList==null) &&!newsUserList.isEmpty()){
            return newsUserList.get(0);
        }else
            return null;
    }
}
