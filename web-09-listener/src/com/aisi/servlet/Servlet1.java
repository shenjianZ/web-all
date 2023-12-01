package com.aisi.servlet;

import com.aisi.listener.MyActivationListener;
import com.aisi.listener.SessionBindingListener;
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
        ServletContext application = req.getServletContext();
        //增添应用域的属性
        application.setAttribute("key","shenjianZ");
        //第一次获取时返回一个新的session
        HttpSession session = req.getSession();
        //增添会话域的属性
        session.setAttribute("scope",100);
//        //手动销毁session
//        session.invalidate();
        //增添请求域的属性
        req.setAttribute("type","yyds");


        SessionBindingListener sessionBindingListener=new SessionBindingListener();
        //session绑定此 监听器
        session.setAttribute("sessionBindingListener",sessionBindingListener);
        //session解除绑定此 监听器
        session.removeAttribute("sessionBindingListener");

        MyActivationListener myActivationListener = new MyActivationListener();
        //session绑定此 监听器
        session.setAttribute("myActivationListener",myActivationListener);
        //session解除绑定此 监听器
        session.removeAttribute("myActivationListener");


    }
}
