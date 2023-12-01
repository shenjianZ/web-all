package com.aisi.schedule.service.impl;

import com.aisi.schedule.dao.SysUserDao;
import com.aisi.schedule.dao.impl.SysUserDaoImpl;
import com.aisi.schedule.pojo.SysUser;
import com.aisi.schedule.service.SysUserService;
import com.aisi.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao=new SysUserDaoImpl();

    /**
     * 注册一个用户
     *
     * @param user 要注册的用户的用户名和明文密码 封装的对象
     * @return 返回数据库影响的行数
     */
    @Override
    public int regist(SysUser user) {
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        int rows=userDao.addSysUser(user);
        return rows;
    }

    /**
     * 查询一个用户
     * @param username 要查询的用户的用户名和明文密码 封装的对象
     * @return  返回数据库影响的行数
     */
    @Override
    public SysUser findByUsername(String username) {
        SysUser byUsername = userDao.findByUsername(username);
        return byUsername;
    }
}
