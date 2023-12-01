package com.aisi.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        //修改应用域的属性
        application.setAttribute("key","66666");

        //第一次获取时返回一个新的session
        HttpSession session = req.getSession();
        //修改会话域的属性
        session.setAttribute("scope",50);
//        //手动销毁session
//        session.invalidate();
        //修改请求域的属性
        req.setAttribute("type","fail");
    }
}
