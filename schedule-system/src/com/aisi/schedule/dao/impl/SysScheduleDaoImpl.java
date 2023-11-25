package com.aisi.schedule.dao.impl;

import com.aisi.schedule.dao.BaseDao;
import com.aisi.schedule.dao.SysScheduleDao;
import com.aisi.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * SysScheduleDaoImpl
 * Author: shenjianZ
 * Date: 2023-11-25
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    /**
     * 向数据库添加一条记录
     * @param schedule  日程数据以Schedule对象方式来写入记录
     * @return 返回影响数据库的行数，为0说明添加失败
     */
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql="insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows;
        rows = baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return rows;
    }

    /**
     * 查询数据中的记录
     * @return 返回查询的日程结果集
     */
    @Override
    public List<SysSchedule> findAll() {
        String sql="select sid,uid,title,completed from sys_schedule;";
        List<SysSchedule> scheduleList;
        scheduleList = baseQuery(SysSchedule.class, sql);
        return scheduleList;
    }

}
