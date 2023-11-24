package com.aisi;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.IOException;


public class servlet3  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=getServletContext();
        String encoding=context.getInitParameter("encoding");
        System.out.println("encoding: "+encoding);
        //获得项目中的文件的真实磁盘路径
        String path=context.getRealPath("upload");
        System.out.println(path);
        //获得项目部署的context 上下文访问路径
        String contextPath = context.getContextPath();
        System.out.println(contextPath);
        //读取servletcontext获取属性
        String email = (String)context.getAttribute("email");
        System.out.println("email:"+email);

    }
}
