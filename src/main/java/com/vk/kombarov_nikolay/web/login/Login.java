package com.vk.kombarov_nikolay.web.login;

import com.vk.kombarov_nikolay.model.user.User;
import com.vk.kombarov_nikolay.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Сценарий:
 * <p>
 * 1)Пользователь заходит без параметров:
 * отображается надпись "Введите имя и пароль" и происходит перенаправление на страницу входа
 * 2)Пользователь заходит с парметрами:
 * 1.Не проходят проверку:
 * Отображается надпись о том, что данные не верны и перенаправляют на страницу входа
 * 2.Проходит проверку
 * Добавляет в сессию объект sessionUser, имя и пароль в cookie и перенаправляет на страницу с указанным id
 * 3.Ошибка при обращении к бд:
 * <p>
 * Created by nikolaykombarov on 01.01.17.
 */

@Controller
public class Login {

    @Autowired
    private User sessionUser;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", sessionUser);
        return "Login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest req) throws Exception {
        if (!userService.verifyUser(user)) {
            model.addAttribute("title", "Ошибка");
            return "Login/login";
        } else {
            User dbEquivalent = userService.getUser(user.getUsername());
            sessionUser.setUsername(dbEquivalent.getUsername());
            sessionUser.setPassword(dbEquivalent.getPassword());
            sessionUser.setFirstName(dbEquivalent.getFirstName());
            sessionUser.setLastName(dbEquivalent.getLastName());
            req.setAttribute("sessionUser", sessionUser);
            return "redirect:/homepage/" + user.getUsername();
        }
    }
}


//    private static DataBaseInstance dao;
//
//    private static Logger logger;
//    private static Logger daoLogger;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        dao = (DataBaseInstance) getServletContext().getAttribute("DataBaseInstance");
//
////        userDao = (Dao) getServletContext().getAttribute("userDao");
//
//        logger = Logger.getLogger(Login.class);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        boolean isPassed = false;
//
//
//        if (username == null || password == null) {
//            req.setAttribute("title", "Введите имя и пароль");
//            req.getRequestDispatcher("/jsp/Login/login.jsp").forward(req, resp);
//        } else {
//            try {
//                isPassed = dao.verify(username, password);
//
//            } catch (SQLException e) {
//                logger.warn(String.format("Error while requesting db, now redirecting sessionUser#%s back", username), e);
//                daoLogger.error("Error while trying to login", e);
//                req.setAttribute("title", "Во время обращения к базе данных возникла ошибка");
//                req.getRequestDispatcher("/jsp/Login/login.jsp").forward(req, resp);
//            }
//            if (isPassed) {
//                logger.info(String.format("User #%s did login into system", username));
//                AdderToSession.addUserObjects(req, username, password);
//                resp.sendRedirect("/homepage/?username=" + username);
//            } else {
//                logger.info(String.format("Failed attempt to login with params: username=%s & password=%s", username, password));
//                req.setAttribute("title", "Имя или пароль неверны, попробуйте ещё раз");
//                req.getRequestDispatcher("/jsp/Login/login.jsp").forward(req, resp);
//            }
//        }
//    }
