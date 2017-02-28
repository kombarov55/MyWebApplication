package com.vk.kombarov_nikolay.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikolaykombarov on 20.01.17.
 */
public class DatabaseInitialization implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        String connectionStatus = (String) servletRequest.getServletContext().getAttribute("connection_status");
//        if (connectionStatus.equals("FAILED")) {
//            resp.sendRedirect("/jsp/fail.html");
//        } else
//            filterChain.doFilter(servletRequest, servletResponse);
    }
}
