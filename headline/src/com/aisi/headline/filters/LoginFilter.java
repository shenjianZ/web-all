package com.aisi.headline.filters;

import com.aisi.headline.common.Result;
import com.aisi.headline.common.ResultCodeEnum;
import com.aisi.headline.util.JwtHelper;
import com.aisi.headline.util.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/headline/*")
public class LoginFilter implements Filter {
    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        if(token!=null && !JwtHelper.isExpiration(token))
            filterChain.doFilter(request,response);
        else
            WebUtil.writeJson(response, Result.build(null, ResultCodeEnum.NOTLOGIN));

    }
}
