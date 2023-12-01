package com.aisi.schedule.dao;

import com.aisi.schedule.pojo.SysUser;

import java.util.List;

public interface SysUserDao {

    /**
     * 添加一条用户记录
     * @param user 记录以SysUser对象方式记录
     * @return  返回数据库受影响的行数
     */
    int addSysUser(SysUser user);

    SysUser findByUsername(String username);
    List<SysUser> findAll();
}
