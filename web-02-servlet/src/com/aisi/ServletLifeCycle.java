package com.aisi;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 *  servlet生命周期
 *  servlet在TomCat中是单例的，因而servlet的成员变量在多个线程栈中是共享的
 *  最好不要修改成员变量，否则会引起线程安全问题
 *  .
 *  default-servlet：这是什么呢？
 *      <servlet>
 *         <servlet-name>default</servlet-name>
 *         <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
 *         <init-param>
 *             <param-name>debug</param-name>
 *             <param-value>0</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>listings</param-name>
 *             <param-value>false</param-value>
 *         </init-param>
 *         <load-on-startup>1</load-on-startup>
 *     </servlet>
 *  当你的请求路径没有与之匹配的servlet，上述的default这个servlet就会成功匹配
 * .
 * .
 * .
 *  1 顶级的Servlet接口
 *  public interface Servlet {
 *      //初始化方法，由tomcat来调用执行
 *     void init(ServletConfig var1) throws ServletException;
 *      //获得 ServletConfig对象的方法
 *     ServletConfig getServletConfig();
 *      //接受用户请求，用于响应信息的方法
 *     void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *      //获取Servlet的描述字符串的方法
 *     String getServletInfo();
 *      //servlet在回收前，tomcat调用的销毁方法，释放资源
 *     void destroy();
 *  }
 *  2 GenericServlet 抽象类
 *  public abstract class GenericServlet implements Servlet, ServletConfig, Serializable {
 *      private transient ServletConfig config;
 *      public void destroy() {
 *     }
 *     public void init(ServletConfig config) throws ServletException {
 *          this.config = config;
 *          this.init();
 *     }
 *     public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *  }
 *  3 HttpServlet 抽象类
 *  public abstract class HttpServlet extends GenericServlet {
 *
 *  }
 *
 *
 */
@WebServlet("/servlet-lifecycle")
public class ServletLifeCycle extends HttpServlet {
    public ServletLifeCycle(){
        System.out.println("构造器!......");
    }

    @Override
    public void init() {
        System.out.println("初始化！......");
    }

/*    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("服务！......");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法......");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法......");
    }

    @Override
    public void destroy() {
        System.out.println("销毁！......");
    }
}
