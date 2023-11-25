package com.aisi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 响应重定向：
 * 由HttpServletResponse实现
 * 由服务端的resp进行重定向指示
 * 客户端将根据 location 的url去访问新的路径，地址栏变化
 * 至少发起了两个请求 ，产生多个req、resp对象
 * 目标资源可以是静态资源html，不能是WEB-INF下的资源，但是可以使外部资源如http://shenjianl.cn
 *
 */
@WebServlet("/servletD")
public class servletD extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的解码字符集
        req.setCharacterEncoding("UTF-8");
        System.out.println("ServletD执行…………");
//        resp.sendRedirect("servletE");
//        resp.sendRedirect("a.html");
        resp.sendRedirect("http://shenjianl.cn");
    }
}
