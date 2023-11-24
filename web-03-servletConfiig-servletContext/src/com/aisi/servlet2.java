package com.aisi;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        urlPatterns = "/servlet2",
        initParams = {
                @WebInitParam(name = "name", value = "Aisi"),
                @WebInitParam(name = "age", value = "20")
        }
)
public class servlet2  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        System.out.println("name: "+name);
        String age=config.getInitParameter("age");
        System.out.println("age: "+age);
        ServletContext context = getServletContext();
        //向servletcontext中添加属性
        context.setAttribute("email","shenjianZLT@gmail.com");
    }
}
