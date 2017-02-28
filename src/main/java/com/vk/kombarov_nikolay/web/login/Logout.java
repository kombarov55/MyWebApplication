package com.vk.kombarov_nikolay.web.login;

import com.vk.kombarov_nikolay.web.util.StringExtractor;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikolaykombarov on 03.01.17.
 */

@Controller
public class Logout extends HttpServlet {

    @RequestMapping(value="/Logout.do", method = RequestMethod.GET)
    public String logOut(HttpServletRequest req) {
        req.getSession().invalidate();
        return "redirect:/";
    }

    @Override
    public void init() throws ServletException {
//        super.init();
//        logger = Logger.getLogger(Login.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = StringExtractor.getStrFromSession(req, "username");
//
//        req.getSession().removeAttribute("username");
//        req.getSession().removeAttribute("user");
//
//        req.getSession().invalidate();
//
//        NDC.push(username);
//        logger.info("User #" + username + " has logged out");
//        NDC.pop();
//        NDC.clear();
//
//        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
