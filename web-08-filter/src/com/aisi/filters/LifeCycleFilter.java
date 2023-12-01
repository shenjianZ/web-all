package com.aisi.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(value = "/*" ,initParams = {
        @WebInitParam(name = "email",value = "shenjainZ@gmail.com")
})
public class LifeCycleFilter implements Filter {


    public LifeCycleFilter(){
        System.out.println("lifeCycle：构造器！！！");
    }
    /**
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("liftCycle:初始化！！！");
        String email = filterConfig.getInitParameter("email");
        System.out.println("从init-param接受的初始化参数：email："+email);
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("lifeCycleFilter过滤");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     *
     */
    @Override
    public void destroy() {
        System.out.println("liftCycle：销毁！！！");
    }
}
