package com.aisi.headline.controller;


import com.aisi.headline.common.Result;
import com.aisi.headline.pojo.NewsType;
import com.aisi.headline.pojo.vo.HeadlineDetailVo;
import com.aisi.headline.pojo.vo.HeadlineQueryVo;
import com.aisi.headline.service.NewsHeadlineService;
import com.aisi.headline.service.NewsTypeService;
import com.aisi.headline.service.impl.NewsHeadlineServiceImpl;
import com.aisi.headline.service.impl.NewsTypeServiceImpl;
import com.aisi.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/protal/*")
public class ProtalController extends BaseController {
    private NewsTypeService typeService= new NewsTypeServiceImpl();
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NewsType>  newsTypeList=typeService.findAll();
        Result result=Result.ok(newsTypeList);
        WebUtil.writeJson(resp,result);
    }


    /**
     * 查询所有分页数据的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        Map pageInfo = headlineService.fingPage(headlineQueryVo);
        Map data = new HashMap();
        data.put("pageInfo",pageInfo);
        Result result=Result.ok(data);
        WebUtil.writeJson(resp,result);
    }

    /**
     * 查询头条详情接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));
        HeadlineDetailVo headlineDetailVo=  headlineService.findHeadlineDetail(hid);
        Result result = null;
        Map data = new HashMap();
        data.put("headline",headlineDetailVo);
        result = Result.ok(data);
        WebUtil.writeJson(resp,result);
    }
}
