package com.aisi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/servlet4")
public class servlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("请求方式："+req.getMethod());
        System.out.println("请求协议："+req.getScheme());
        System.out.println("请求协议及版本："+req.getProtocol());
        System.out.println("URI："+req.getRequestURI());
        System.out.println("URL："+req.getRequestURL());
        /* ..
         * URI /web-03/servlet4
         * URL http://localhost:8080/web-03/servlet4
         *
         **/
        System.out.println("应用容器的端口号："+req.getLocalPort());
        System.out.println("客户端软件发起请求的端口号："+req.getRemotePort());
        System.out.println("客户端软件的端口号："+req.getServerPort());
        // 获取某一个请求头
        String accept = req.getHeader("Accept");
        System.out.println(accept);
        //获取所有请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s+":"+req.getHeader(s));
        }
    }
}
