package com.vk.kombarov_nikolay.web.dialog;

import com.vk.kombarov_nikolay.model.database.Dao;
import com.vk.kombarov_nikolay.model.messenger.Dialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nikolaykombarov on 07.01.17.
 * <p>
 * Сценарий:
 * 1) Пользователь зашел без параметра: отправляем его на страницу выбора диалога
 * 2) Параметр есть: отправляем пользователя на jsp диалога с листом сообщений
 */
@Controller
public class ChosenDialog {

    @Autowired
    private Dialog chosenDialog;

    @Autowired
    private Dao<Dialog> dialogDao;

    @RequestMapping(value = "/homepage/im/{tableName}", method = RequestMethod.GET)
    public String concreteDialog(@PathVariable("tableName") String tableName) throws Exception {
        if (!tableName.equals(chosenDialog.getTableName()))
            chosenDialog = dialogDao.get(tableName);
        return "Dialog/chosendialog";
    }
}
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String chosenDialogName = req.getParameter("id");
//        User user = (User) req.getSession().getAttribute("user");
//
//        //Если зашли без параметра
//        if (chosenDialogName == null) {
//            resp.sendRedirect("homepage/dialogs");
//            return;
//        }
//
//        user.setChosenDialog(chosenDialogName);
//
//        Dialog dialog = user.getChosenDialog();
//        List<Message> messages = dialog.getMessages();
//
//        req.getSession().setAttribute("messages", messages);
//        req.getRequestDispatcher("/jsp/Dialog/chosendialog.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }

