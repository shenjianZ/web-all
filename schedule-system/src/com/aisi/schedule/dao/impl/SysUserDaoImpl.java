package com.aisi.schedule.dao.impl;

import com.aisi.schedule.dao.BaseDao;
import com.aisi.schedule.dao.SysUserDao;
import com.aisi.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    /**
     * 添加一条用户记录
     * @param user 记录以SysUser对象方式记录
     * @return  返回数据库受影响的行数
     */
    @Override
    public int addUser(SysUser user) {
        String sql="insert into sys_user values(?,?,?);";
        int row;
        row = baseUpdate(sql,user.getUid(), user.getUsername(), user.getUserPwd());
        return row;
    }

    /**
     * 查询所有的用户记录
     * @return 用户记录的List集合结果集
     */
    @Override
    public List<SysUser> findAll() {
        String sql="select uid,username,user_pwd userPwd from sys_user";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql);
        return sysUserList;
    }

/*    public static void main(String[] args) {
        new SysUserDaoImpl().findAll().forEach(System.out::println);
        new SysUserDaoImpl().addUser(new SysUser(null,"yu","4548"));
    }*/
}
