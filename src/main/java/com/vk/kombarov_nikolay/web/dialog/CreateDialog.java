package com.vk.kombarov_nikolay.web.dialog;

import javax.servlet.http.HttpServlet;


/**
 * Created by nikolaykombarov on 07.01.17.
 * TODO: сюда можно зайти только с формы!
 */
public class CreateDialog extends HttpServlet {

//    private static UserService userManager;
//    private static MessengerService messengerService;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//
//        userManager = (UserService) getServletContext().getAttribute("UserServiceImpl");
//        messengerService = (MessengerService) getServletContext().getAttribute("MessengerService");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username2 = req.getParameter("username2");
//
//        if (username2 == null) {
//            List<String> usernames = userManager.getUserNames();
//            req.setAttribute("usernames", usernames);
//            req.getRequestDispatcher("/jsp/Dialog/createdialog.jsp").forward(req, resp);
//        } else {
//            String username1 = req.getRemoteUser();
//            User user1 = (User) req.getSession().getAttribute("user");
//            User user2 = userManager.getUser(username2);
//            try {
//                messengerService.createDialog(user1, user2);
//                String tableName = TableNameCreator.createTableName(username1, username2);
//                resp.sendRedirect("/homepage/dialogs/chosenDialog?dialog=" + tableName);
//            } catch (SQLException e) {
//                req.setAttribute("errorMessage", e.getMessage());
//                req.getRequestDispatcher("fail.jsp").forward(req, resp);
//            }
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
}
