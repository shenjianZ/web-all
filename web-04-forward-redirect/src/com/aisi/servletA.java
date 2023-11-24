package com.aisi;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 请求转发：
 * 通过HttpServletRequest来完成的
 * 是在服务器内部进行的
 * 客户端只产生一次请求，仅有一对req、resp
 * 客户端地址栏不变
 * .
 *
 */
@WebServlet("/servletA")
public class servletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletA执行…………");
        //获得请求转发器
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
        requestDispatcher.forward(req,resp);
    }
}
