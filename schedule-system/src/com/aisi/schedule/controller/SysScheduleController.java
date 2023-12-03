package com.aisi.schedule.controller;


import com.aisi.schedule.common.Result;
import com.aisi.schedule.pojo.SysSchedule;
import com.aisi.schedule.service.SysScheduleService;
import com.aisi.schedule.service.SysUserService;
import com.aisi.schedule.service.impl.SysScheduleServiceImpl;
import com.aisi.schedule.service.impl.SysUserServiceImpl;
import com.aisi.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.digester.RuleSet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 *
 *
 *
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController{
    private SysScheduleService scheduleService = new SysScheduleServiceImpl();
    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("uid"));
        int uid = Integer.parseInt(req.getParameter("uid"));
        List<SysSchedule> itemList= scheduleService.findItemByUid(uid);
        Map data=new HashMap();
        data.put("itemList",itemList);
        Result result = Result.ok(data);
        WebUtil.writeJson(resp, result);
    }


    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        scheduleService.addDefaultSchedule(uid);
        Result result = Result.ok(null);
        WebUtil.writeJson(resp, result);
    }


    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysSchedule schedule = WebUtil.readJson(req, SysSchedule.class);
        scheduleService.updateSchedule(schedule);
        Result result = Result.ok(null);
        WebUtil.writeJson(resp,result);
    }


    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        scheduleService.removeSchedule(sid);
        Result result = Result.ok(null);
        WebUtil.writeJson(resp,result);
    }
}

