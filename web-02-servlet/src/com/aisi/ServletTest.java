package com.aisi;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * servlet开发流程
 * 1 创建JavaWeb项目，同时将TomCat添加为当前项目的依赖
 * 2 重写service方法 service(HttpServletRequest req, HttpServletResponse resp)
 * 3 在web.xml中，配置servlet对应的请求映射路径
 * 4 servlet-api.jar导入问题 ：
 *      运行时可由运行环境（TomCat）来提供，无需额外导入
 * 5 Content-Type响应头问题:
 *
 *
 * */
public class ServletTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从 req 中获取对应参数信息
        String name=req.getParameter("username");
        //处理业务代码,将数据写入响应体 resp
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        if("shenjianZ".equals(name))
            resp.getWriter().write("YES");
        else
            resp.getWriter().write("NO");
    }
}
