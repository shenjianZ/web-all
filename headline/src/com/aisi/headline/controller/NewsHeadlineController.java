package com.aisi.headline.controller;


import com.aisi.headline.common.Result;
import com.aisi.headline.common.ResultCodeEnum;
import com.aisi.headline.pojo.NewsHeadline;
import com.aisi.headline.service.NewsHeadlineService;
import com.aisi.headline.service.impl.NewsHeadlineServiceImpl;
import com.aisi.headline.util.JwtHelper;
import com.aisi.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController{

    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token= req.getHeader("token");
        Long userId = JwtHelper.getUserId(token);
        Result result= Result.build(null, ResultCodeEnum.SUCCESS);
        NewsHeadline headline=WebUtil.readJson(req,NewsHeadline.class);
        headline.setPublisher(userId.intValue());
        headlineService.addNewsHeadline(headline);
        WebUtil.writeJson(resp,result);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid=Integer.parseInt(req.getParameter("hid"));
        NewsHeadline headline =headlineService.findHeadlineByHid(hid);
        Result  result = null;
        Map data= new HashMap();
        data.put("headline",headline);
        result=Result.build(data,ResultCodeEnum.SUCCESS);
        WebUtil.writeJson(resp,result);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline headline = WebUtil.readJson(req, NewsHeadline.class);
        headlineService.update(headline);
        Result result = Result.build(null, ResultCodeEnum.SUCCESS);
        WebUtil.writeJson(resp,result);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid")) ;
        headlineService.removeHeadlineByHid(hid);
        Result result = Result.build(null, ResultCodeEnum.SUCCESS);
        WebUtil.writeJson(resp,result);
    }
}
