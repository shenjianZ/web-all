package com.aisi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookieA = new Cookie("cookie-A","aaaaa");
        Cookie cookieB = new Cookie("cookie-B","bbbbb");
        //最大存在时间  秒
        cookieA.setMaxAge(500);
        cookieB.setMaxAge(500);
        //设置提交路径 ,其他路径不提交
        cookieA.setPath("/servlet2");
        resp.addCookie(cookieA);
        resp.addCookie(cookieB);
    }
}
