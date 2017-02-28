package com.vk.kombarov_nikolay.web.filters;

import com.vk.kombarov_nikolay.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nikolaykombarov on 13.02.17.
 */
public class AlreadyLoggedInFilter extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User sessionUser = (User) request.getSession().getAttribute("sessionUser");
        if (sessionUser == null || (sessionUser.getUsername() != null && sessionUser.getPassword() != null))
            return true;
        else {
            response.sendRedirect("/homepage/" + sessionUser.getUsername());
            return false;
        }
    }
}
