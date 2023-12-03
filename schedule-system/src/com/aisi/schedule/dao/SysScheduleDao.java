package com.aisi.schedule.dao;

import com.aisi.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {

    int addSchedule(SysSchedule schedule);

    List<SysSchedule> findAll();

    List<SysSchedule> findItemByUid(int uid);

    Integer addDefaultSchedule(int uid);

    Integer updateSchedule(SysSchedule schedule);

    Integer removeSchedule(int sid);
}
