package com.aisi.headline.controller;


import com.aisi.headline.common.Result;
import com.aisi.headline.pojo.NewsType;
import com.aisi.headline.service.NewsTypeService;
import com.aisi.headline.service.impl.NewsTypeServiceImpl;
import com.aisi.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/protal/*")
public class ProtalController extends BaseController {
    private NewsTypeService service= new NewsTypeServiceImpl();
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NewsType>  newsTypeList=service.findAll();
        Result result=Result.ok(newsTypeList);
        WebUtil.writeJson(resp,result);
    }
}
