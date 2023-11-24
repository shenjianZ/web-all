package com.aisi;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("/servlet5")
public class servlet5 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("获取单个参数：");
        String fname = req.getParameter("fname");
        System.out.println("name:"+fname);
        String lname = req.getParameter("lname");
        System.out.println("lname:"+lname);
        System.out.println("获取多个参数：");
        String[] parameterValues = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(parameterValues));
        System.out.println("一次获取所有参数：");
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String s=parameterNames.nextElement();

            System.out.println(s+" : "+req.getParameter(s));
        }
        BufferedReader reader = req.getReader();
        ServletInputStream inputStream = req.getInputStream();



    }
}
