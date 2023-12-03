package com.aisi.schedule.service.impl;

import com.aisi.schedule.dao.SysScheduleDao;
import com.aisi.schedule.dao.impl.SysScheduleDaoImpl;
import com.aisi.schedule.pojo.SysSchedule;
import com.aisi.schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {

    private SysScheduleDao scheduleDao = new SysScheduleDaoImpl();

    /**
     * @param uid
     * @return
     */
    @Override
    public List<SysSchedule> findItemByUid(int uid) {
        return scheduleDao.findItemByUid(uid);
    }

    /**
     *
     * @param uid
     * @return
     */
    @Override
    public Integer addDefaultSchedule(int uid) {
        return scheduleDao.addDefaultSchedule(uid);
    }

    /**
     * @param schedule
     * @return
     */
    @Override
    public Integer updateSchedule(SysSchedule schedule) {
       return scheduleDao.updateSchedule(schedule);
    }

    /**
     * @param sid
     * @return
     */
    @Override
    public Integer removeSchedule(int sid) {
       return scheduleDao.removeSchedule(sid);
    }
}
