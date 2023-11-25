package com.aisi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 响应体乱码解决：
 * 1  resp.setCharacterEncoding("GBK");将响应体的文本转换为GBK来发送给客户端，不推荐
 * 2  resp.setContentType("text/html;charset=utf-8");
 *    resp.setHeader("charset", "UTF-8");
 *    根据响应体的编码来设置charset属性，告诉客户端响应体文本的编码
 *
 */
@WebServlet("/servletF")
public class servletF extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletF执行…………");
        //这种方式不推荐
//        resp.setCharacterEncoding("GBK");
        //以下两者均可，设置响应头，对charset更改为UTF-8，根据响应体的编码来设置
        resp.setContentType("text/html;charset=utf-8");
//        resp.setHeader("charset", "UTF-8");
        resp.getWriter().write("你好！！！world");
    }
}
