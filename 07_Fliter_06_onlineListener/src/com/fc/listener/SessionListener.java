package com.fc.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class SessionListener implements HttpSessionAttributeListener {
    // session中attribute的个数，同时，也是在线的人数
    private static int cont = 0;
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        cont++;
        // 将人数存到上下文对象中
        httpSessionBindingEvent.getSession().getServletContext().setAttribute("cont",SessionListener.cont);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        cont--;
        // 将人数存到上下文对象中
        httpSessionBindingEvent.getSession().getServletContext().setAttribute("cont",SessionListener.cont);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
