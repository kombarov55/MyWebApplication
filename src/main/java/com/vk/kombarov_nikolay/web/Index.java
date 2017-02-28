package com.vk.kombarov_nikolay.web;

import com.vk.kombarov_nikolay.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Сценарий:
 * 1)Пользователь не имеет cookie: так как cookie не содержит имени и пароля, то перенаправляем его на титульную страницу
 * 2) Пользователь имеет cookie и ссылки на свои объекты: перенаправляется на свою страницу
 * 3) Пользователь имеет cookie, но сессия просрочилась(новая): перенаправляется на страницу входа, на которой ему
 * положат эти объекты в сессию.
 * Created by nikolaykombarov on 02.01.17.
 */

@Controller
@RequestMapping("/")
public class Index {

    @Autowired
    public User sessionUser;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        if (sessionUser.getUsername() != null)
            return "redirect:/homepage/" + sessionUser.getUsername();
        return "index";
    }
}


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String connection_status = (String) getServletContext().getAttribute("connection_status");
//        if (connection_status.equals("FAILED")) {
//            resp.sendRedirect("jsp/fail.html");
//            return;
//        }
//        if (req.getCookies() != null) {
//            String username = StringExtractor.getStrFromSession(req, "username");
//            String password = StringExtractor.getStrFromSession(req, "password");
//
//
//
//            if (username.isEmpty() || password.isEmpty()) {
//                req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
//            } else if (req.getSession().isNew()) {
//                req.getRequestDispatcher("/login/?username=" + username + "&password=" + password).forward(req, resp);
//            } else {
//                req.getRequestDispatcher("homepage/").forward(req, resp);
//            }
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
