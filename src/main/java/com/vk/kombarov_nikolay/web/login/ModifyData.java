package com.vk.kombarov_nikolay.web.login;

import com.vk.kombarov_nikolay.model.database.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikolaykombarov on 04.01.17.
 */
public class ModifyData extends HttpServlet {


    private static Dao userDao;

    @Override
    public void init() throws ServletException {
//        super.init();
//        userDao = (Dao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = StringExtractor.getStrFromSession(req, "username");
//        String newPassword = req.getParameter("password");
//
//        String title;
//        if (newPassword == null) {
//            title = "Введите данные";
//        } else if (Validator.validatePassword(newPassword)) {
//            try {
//                userDao.update(username, newPassword);
//            } catch (SQLException e) {
//                req.setAttribute("title", "возникла ошибка при обращении к базе данных; сообщение: " + e.getMessage());
//                req.getRequestDispatcher("/modify.jsp").forward(req, resp);
//            }
//            resp.addCookie(new Cookie("password", newPassword));
//            title = "Успешно";
//        } else {
//            title = "Пароль не подходит, попробуйте ещё раз";
//        }
//        req.setAttribute("title", title);
//        req.getRequestDispatcher("/jsp/Homepage/modify.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
