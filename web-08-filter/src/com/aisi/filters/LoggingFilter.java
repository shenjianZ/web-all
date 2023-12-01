package com.aisi.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingFilter implements Filter {

    private SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        //放行之前，请求到达目标资源之前
//         System.out.println("loggingFilter before chain.doFilter invoked!");
        String requestURI= request.getRequestURI();
        String time=dateFormat.format(new Date());
        String before=requestURI+"在"+time+"被请求";
        System.out.println(before);
        long t1=System.currentTimeMillis();
        //放行
        filterChain.doFilter(request,response);
        //响应之前的代码
//        System.out.println("loggingFilter after chain.doFilter invoked!");
        long t2=System.currentTimeMillis();
        String after=requestURI+"在"+time+"耗时"+(t2-t1)+"ms";
        System.out.println(after);

    }
}
