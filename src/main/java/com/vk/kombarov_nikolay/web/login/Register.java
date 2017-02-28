package com.vk.kombarov_nikolay.web.login;

import com.vk.kombarov_nikolay.model.user.User;
import com.vk.kombarov_nikolay.model.user.UserService;
import com.vk.kombarov_nikolay.model.user.util.Validator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Сценарий:
 * 1)Заходят без параметров:
 * Отображается надпись о введении данных и перенаправляется на страницу регистрации
 * 2)Заходят с параметрами:
 * 1.Подходят: происходит перенаправление по урлу на страницу входа с этими же параметрами //TODO: наверное нужно диспатчить
 * 2.Не проходят: Отображается запись о том, что не подходят данные и перенаправляется на страницу регистрации
 * 3.Ошибка при обращении к бд: отбражается сообщение об ошибке
 * Created by nikolaykombarov on 01.01.17.
 */
@Controller
@RequestMapping("/register")
public class Register extends HttpServlet {

    @Autowired
    public User sessionUser;

    @Autowired
    private UserService userService;

    private static Logger logger;

    @RequestMapping(method = RequestMethod.GET)
    public String firstAttempt(Model model) {
        model.addAttribute("title", "Введите ваши данные");
        model.addAttribute("user", sessionUser);
        return "Login/register";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String validateAndReact(
            User user,
            Model model
    ) throws SQLException {
        if (userService.validateUser(user)) {
            sessionUser.username = user.username;
            sessionUser.password = user.password;
            userService.addUser(user);
            return "redirect:/homepage/" + sessionUser.getUsername();
        } else {
            model.addAttribute("title", "Ошибка, попробуйте ещё раз");
            return "Login/register";
        }
    }

    @Override
    public void init() throws ServletException {
//        super.init();
//
//        userDao = (Dao) getServletContext().getAttribute("userDao");
//        userService = (UserService) getServletContext().getAttribute("UserServiceImpl");
//
//        logger = Logger.getLogger(Register.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String passwordRepeat = req.getParameter("passwordRepeat");
//
//        if (username == null || password == null || passwordRepeat == null) {
//            req.setAttribute("title", "Введите ваше имя пользователя и пароль");
//            req.getRequestDispatcher("/jsp/Login/register.jsp").forward(req, resp);
//        }
//
//
//        /*
//           Если данные подходящие, то происходит redirect на страницу логина с этими данными:
//           происходит вход, иначе возвращает на ту же страницу
//         */
//
//        else {
//            try {
//                boolean containsUser = (userDao.get(username) == "");
//                if (!containsUser && Validator.validate(username, password) && password.equals(passwordRepeat)) {
//                    logger.info(String.format("User #%s has successfully registered", username));
//
//                    userService.addUser(username, password);
//                    //TODO: уже надо в другое место
//                    req.getRequestDispatcher("/login/").forward(req, resp);
//                } else {
//                    logger.info(String.format("Failed attempt to register with params: username=%s & password=%s", username, password));
//                    req.setAttribute("title", "Имя или пароль неподходящие, попробуйте ещё раз");
//                    req.getRequestDispatcher("/jsp/Login/register.jsp").forward(req, resp);
//                }
//            } catch (SQLException e) {
//                logger.warn("Error while requesting database", e);
//                req.setAttribute("title", "Во время обращения к базе данных произошла ошибка; сообщение:" + e.getMessage());
//                req.getRequestDispatcher("/jsp/Login/register.jsp").forward(req, resp);
//            }
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
