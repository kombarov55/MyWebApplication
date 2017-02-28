package com.vk.kombarov_nikolay.web.listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by nikolaykombarov on 14.01.17.
 */
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
//        ServletContext ctx = se.getSession().getServletContext();
//
//        //TODO: возможно нужен Integer
//        int counter = (int) ctx.getAttribute("SessionCounter");
//        ctx.setAttribute("SessionCounter", ++counter);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
//        ServletContext ctx = se.getSession().getServletContext();
//        int counter = (int) ctx.getAttribute("SessionCounter");
//        ctx.setAttribute("SessionCounter", --counter);
    }
}
