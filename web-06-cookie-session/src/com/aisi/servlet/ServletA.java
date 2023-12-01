package com.aisi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/servletA")

public class ServletA  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("ID:"+session.getId());
        boolean aNew = session.isNew();
        System.out.println("IsNew"+aNew);
        String username=req.getParameter("username");
        session.setAttribute("username",username);
        resp.getWriter().write("Session ID: " + session.getId() + "\n, New: " + aNew);
    }
}
