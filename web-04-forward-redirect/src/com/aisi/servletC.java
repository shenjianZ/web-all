package com.aisi;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 *
 * 请求转发：
 * 目标资源可以是 html静态资源 、servlet动态资源
 * 或受保护资源WEB-INF，也仅有请求转发可访问WEB-INF
 * 请求转发仅可访问项目内部资源
 *
 */
@WebServlet("/servletC")
public class servletC extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletC执行…………");
        //获得请求转发器
        //请求转发静态资源
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
        //请求转发WEB-INF中的受保护资源
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");
        //此时不可访问，因为请求转发仅可访问项目内部资源
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://shenjianl.cn");
        requestDispatcher.forward(req,resp);
    }
}
