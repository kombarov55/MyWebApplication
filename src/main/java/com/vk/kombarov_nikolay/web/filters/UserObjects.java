package com.vk.kombarov_nikolay.web.filters;

import com.vk.kombarov_nikolay.model.user.User;
import com.vk.kombarov_nikolay.web.util.AdderToSession;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by nikolaykombarov on 20.01.17.
 */
public class UserObjects implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        //TODO: дублируется запрос этого объекта, может поменять по другому?
//        User user = (User) req.getSession().getAttribute("user");
//        if (user == null) {
//            String username = req.getRemoteUser();
//            AdderToSession.setUserObject(req, username);
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
    }
}
