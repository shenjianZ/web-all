package com.aisi.schedule.service;

import com.aisi.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleService {

    /**
     *
     * @param uid
     * @return
     */
    List<SysSchedule> findItemByUid(int uid);

    Integer addDefaultSchedule(int uid);

    Integer updateSchedule(SysSchedule schedule);

    Integer removeSchedule(int sid);
}
