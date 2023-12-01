package com.aisi.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        application.removeAttribute("key");
        //第一次获取时返回一个新的session
        HttpSession session = req.getSession();
        //删除会话域的属性
        session.removeAttribute("scope");
//        //手动销毁session
//        session.invalidate();
        //删除请求域的属性
        req.removeAttribute("type");
    }
}
