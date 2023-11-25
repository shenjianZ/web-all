package com.aisi.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        //获取方法名
        String methodName = split[split.length-1];
        //反射获取方法
        Class aClass = this.getClass();
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //暴力破解方法访问修饰符限制
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
