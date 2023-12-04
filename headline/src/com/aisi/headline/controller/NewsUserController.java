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
     *
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
                data.put("takon",token);
                result=Result.build(data, ResultCodeEnum.SUCCESS);
            }else
                result=Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }else
            result=Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        WebUtil.writeJson(resp, result);
    }
}
