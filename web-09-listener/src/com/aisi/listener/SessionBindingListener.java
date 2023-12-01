package com.aisi.listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class SessionBindingListener implements HttpSessionBindingListener {
    /**
     * session 在绑定此监听器时执行
     * @param event
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {

    }

    /**
     * session 在解除绑定此监听器时执行
     * @param event
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}
