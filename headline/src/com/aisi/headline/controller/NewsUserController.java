package com.aisi.headline.controller;


import com.aisi.headline.common.Result;
import com.aisi.headline.common.ResultCodeEnum;
import com.aisi.headline.pojo.NewsUser;
import com.aisi.headline.service.NewsUserService;
import com.aisi.headline.service.impl.NewsUserServiceImpl;
import com.aisi.headline.util.JwtHelper;
import com.aisi.headline.util.MD5Util;
import com.aisi.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class NewsUserController extends BaseController{

    private NewsUserService userService= new NewsUserServiceImpl();

    /**
     * 用户登录的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser paramUser = WebUtil.readJson(req, NewsUser.class);
        NewsUser loginUser= userService.finaByUsername(paramUser.getUsername());
        Result result=null;
        if(loginUser!=null){
            if(MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())){
                Integer uid = loginUser.getUid();
                String token = JwtHelper.createToken(Long.valueOf(uid));
                Map data = new HashMap();
                data.put("token",token);
                result=Result.build(data, ResultCodeEnum.SUCCESS);
            }else
                result=Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }else
            result=Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        WebUtil.writeJson(resp, result);
    }


    /**
     * 查询已登录用户的信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result result = null;
        if(!(token==null||token.isEmpty())){
           if(!JwtHelper.isExpiration(token)){
               Integer userId = JwtHelper.getUserId(token).intValue();
               NewsUser newsUser= userService.findByUid(userId);
               newsUser.setUserPwd("");
               Map data = new HashMap();
               data.put("loginUser",newsUser);
               result=Result.build(data, ResultCodeEnum.SUCCESS);
           }else
               result=Result.build(null, ResultCodeEnum.NOTLOGIN);
        }else
            result=Result.build(null, ResultCodeEnum.NOTLOGIN);
        WebUtil.writeJson(resp, result);
    }


    /**
     * 查询用户名是否已存在
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        NewsUser newsUser = userService.finaByUsername(username);
        Result result = null;
        if(newsUser!=null)
            result=Result.build(null, ResultCodeEnum.USERNAME_USED);
        else
            result=Result.build(null, ResultCodeEnum.SUCCESS);
        WebUtil.writeJson(resp,result);
    }


    /**
     * 注册业务的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser registUser = WebUtil.readJson(req, NewsUser.class);
        int rows = userService.registUser(registUser);
        Result result = null;
        if(rows>0)
            result = Result.build(null, ResultCodeEnum.SUCCESS);
        else
            result=Result.build(null,ResultCodeEnum.USERNAME_USED);
        WebUtil.writeJson(resp,result);
    }


    /**
     * 查询是否已经登录的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result result = null;
        if(token!=null && !token.isEmpty()){
            if(!JwtHelper.isExpiration(token))
                result = Result.build(null, ResultCodeEnum.SUCCESS);
            else
                result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        else
            result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        WebUtil.writeJson(resp,result);
    }
}
