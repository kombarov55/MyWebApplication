package com.vk.kombarov_nikolay.web.dialog;

import javax.servlet.http.HttpServlet;

/**
 * Created by nikolaykombarov on 07.01.17.
 */
public class SendMessage extends HttpServlet {

//    private static MessengerService ms;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//
//        ms = (MessengerService) getServletContext().getAttribute("MessengerService");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String text = req.getParameter("text");
//        User user = (User) req.getSession().getAttribute("user");
//        Dialog dialog = user.getChosenDialog();
//        String username = req.getRemoteUser();
//
//        try {
//            ms.sendMessage(dialog, username, text);
//        } catch (SQLException e) {
//            req.setAttribute("errorMessage", e.getMessage());
//        } finally {
//            resp.sendRedirect("/homepage/dialogs/chosenDialog?id=" + dialog.getTableName());
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
}
