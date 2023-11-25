package com.aisi.schedule.dao;

import com.aisi.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {

    int addSchedule(SysSchedule schedule);

    List<SysSchedule> findAll();

}
