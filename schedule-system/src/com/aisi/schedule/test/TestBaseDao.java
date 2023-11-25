package com.aisi.schedule.test;

import com.aisi.schedule.dao.BaseDao;
import com.aisi.schedule.pojo.SysUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestBaseDao {

    public static BaseDao baseDao;

    @BeforeAll
    public static void initBaseDao(){
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject(){
        //查询结果集为单行单列的
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery(){
        //查询结果集为多行多列
        String sql="select uid,username,user_pwd userPwd from sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testUpdate(){
        String sql="insert into sys_schedule values(DEFAULT,?,?,?)";
        int row = baseDao.baseUpdate(sql,  1, "C++", 0);
        System.out.println(row);

    }

}











