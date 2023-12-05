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

    /**
     * @param userId
     * @return
     */
    @Override
    public NewsUser finByUid(Integer userId) {
        String sql = "select uid, username, user_pwd as userPwd, nick_name as nickName from news_user where uid = ?";
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, userId);
        if(!(newsUserList==null) &&!newsUserList.isEmpty()){
            return newsUserList.get(0);
        }else
            return null;
    }

    /**
     * @param registUser
     * @return
     */
    @Override
    public int insertUser(NewsUser registUser) {
        String sql="insert into news_user values(DEFAULT,?,?,?);";
        int rows;
        rows=baseUpdate(sql, registUser.getUsername(), registUser.getUserPwd(), registUser.getNickName());
        return rows;
    }
}
