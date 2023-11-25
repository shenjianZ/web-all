package com.aisi.schedule.test;

import com.aisi.schedule.dao.SysScheduleDao;
import com.aisi.schedule.dao.impl.SysScheduleDaoImpl;
import com.aisi.schedule.pojo.SysSchedule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestScheduleDao {

    private static SysScheduleDao SysScheduleDao;
    @BeforeAll
    public static void initScheduleDao(){
        SysScheduleDao=new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule(){
        int rows = SysScheduleDao.addSchedule(new SysSchedule(null,2,"JAVA",1));
        System.out.println(rows);
    }

    @Test
    public void testFindAll(){
        List<SysSchedule> scheduleList = SysScheduleDao.findAll();
        scheduleList.forEach(System.out::println);
    }

}
