package com.aisi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet6")
public class servlet6 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应码
        resp.setStatus(200);
        //设置响应头
        resp.setHeader("content-type","text/html");
        String info = "<h1>shenjianZ</h1>";
        resp.setHeader("content-length",info.getBytes().length+"");
        //设置响应体
        resp.getWriter().write(info);
    }
}
