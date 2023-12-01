package com.aisi.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    /**
     * session域中的属性 增加，执行此方法
     * @param se
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        Object key = session.getAttribute("key");
    }

    /**
     * session域中的属性 删除，执行此方法
     * @param se
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        Object key = session.getAttribute("key");

    }

    /**
     * session域中的属性 更改，执行此方法
     * @param se
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        Object key = session.getAttribute("key");
    }

    /**
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session创建");
    }

    /**
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session销毁");
    }
}
