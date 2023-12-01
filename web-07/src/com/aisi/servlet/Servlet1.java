package com.aisi.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向请求域存放数据
        req.setAttribute("request","requestMessage");
        req.getRequestDispatcher("servlet2").forward(req,resp);
        //向会话域存放数据
        HttpSession session = req.getSession();
        session.setAttribute("session","sessionMessage");
        //向应用域存放数据
        ServletContext application = getServletContext();
        application.setAttribute("application","applicationMessage");
    }
}
