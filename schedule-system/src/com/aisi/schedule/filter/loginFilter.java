package com.aisi.schedule.filter;

import com.aisi.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(value = {"/showSchedule.html","/schedule/*"})
public class loginFilter implements Filter {
    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        SysUser sysUser = (SysUser)session.getAttribute("sysUser");
        if(sysUser==null)
            response.sendRedirect("login.html");
        else
            filterChain.doFilter(request,response);
    }
}
