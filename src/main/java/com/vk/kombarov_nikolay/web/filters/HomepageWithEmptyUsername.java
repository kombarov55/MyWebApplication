package com.vk.kombarov_nikolay.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikolaykombarov on 20.01.17.
 */
public class HomepageWithEmptyUsername implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        String username = req.getParameter("username");
//        if (username == null) {
//            HttpServletResponse resp = (HttpServletResponse) servletResponse;
//            String remoteUsername = req.getRemoteUser();
//            resp.sendRedirect("/homepage/?username=" + remoteUsername);
//        } else
//            filterChain.doFilter(servletRequest, servletResponse);

    }
}
