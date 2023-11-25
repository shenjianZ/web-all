package com.aisi.schedule.dao;

import com.aisi.schedule.pojo.SysUser;

import java.util.List;

public interface SysUserDao {

    int addUser(SysUser user);
    List<SysUser> findAll();
}
