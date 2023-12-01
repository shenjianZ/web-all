package com.aisi.listener;

import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

public class MyActivationListener implements HttpSessionActivationListener {
    /**
     * 当与之绑定的session发生钝化时执行
     * @param se
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {

    }

    /**
     * 当与之绑定的session发生活化时执行
     * @param se
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {

    }
}
