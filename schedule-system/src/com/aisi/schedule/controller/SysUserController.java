package com.aisi.schedule.controller;


import com.aisi.schedule.common.Result;
import com.aisi.schedule.common.ResultCodeEnum;
import com.aisi.schedule.pojo.SysUser;
import com.aisi.schedule.service.SysUserService;
import com.aisi.schedule.service.impl.SysUserServiceImpl;
import com.aisi.schedule.util.MD5Util;
import com.aisi.schedule.util.WebUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();
    /**
     * 注册业务处理的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");
//        SysUser user = new SysUser(null,username,userPwd);
        SysUser user = WebUtil.readJson(req, SysUser.class);
        int rows = userService.regist(user);
        Result result=null;
        if(rows>0)
//            resp.sendRedirect("/registSuccess.html");
            result=Result.build(null,ResultCodeEnum.SUCCESS);
        else
//            resp.sendRedirect("/registFail.html");
            result=Result.build(null,ResultCodeEnum.USERNAME_USED);
        WebUtil.writeJson(resp,result);
    }


    /**
     * 接受登录请求的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
        String username = sysUser.getUsername();
        String userPwd = sysUser.getUserPwd();
        SysUser loginUser = userService.findByUsername(username);
        Result result=null;
        if(null==loginUser){
//            resp.sendRedirect("/loginUsernameError.html");
            result=Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
//            resp.sendRedirect("/loginUserPwdError.html");
            result=Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        } else {
//            HttpSession session = req.getSession();
//            session.setAttribute("sysUser",loginUser);
//            resp.sendRedirect("/showSchedule.html");
            req.getSession().setAttribute("sysUser",loginUser);
            loginUser.setUserPwd("");
            Map<String,Object> data =new HashMap<>();
            data.put("loginUser",loginUser);
            result=Result.build(data,ResultCodeEnum.SUCCESS);

        }
        WebUtil.writeJson(resp,result);
    }


    /**
     * 校验用户名是否被占用的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        SysUser sysUser = userService.findByUsername(username);
        Result result=Result.build(null, ResultCodeEnum.SUCCESS);
        if(sysUser != null)
            result=Result.build(null, ResultCodeEnum.USERNAME_USED);
//        //将result对象转换为JSON串
//        ObjectMapper mapper = new ObjectMapper();
//        String info = mapper.writeValueAsString(result);
//        //告诉客户端响应的类型
//        resp.setContentType("application/json;charset=UTF-8");
//        resp.getWriter().write(info);
        WebUtil.writeJson(resp,result);



    }
}
