package com.aisi.schedule.service;

import com.aisi.schedule.pojo.SysUser;

public interface SysUserService {

    /**
     * 注册一个用户
     * @param user 要注册的用户的用户名和明文密码 封装的对象
     * @return 返回数据库影响的行数
     */
    int regist(SysUser user);

    /**
     * 查询一个用户
     * @param username 要查询的用户的用户名和明文密码 封装的对象
     * @return  返回数据库影响的行数
     */
    SysUser findByUsername(String username);
}
