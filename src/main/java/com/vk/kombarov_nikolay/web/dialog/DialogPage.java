package com.vk.kombarov_nikolay.web.dialog;

import com.vk.kombarov_nikolay.model.messenger.Dialog;
import com.vk.kombarov_nikolay.model.messenger.MessengerService;
import com.vk.kombarov_nikolay.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by nikolaykombarov on 06.01.17.
 */
@Controller
public class DialogPage {

    @Autowired
    public User sessionUser;

    @Autowired
    private MessengerService messengerService;

    @Autowired
    private Dialog chosenDialog;

    @RequestMapping(value = "homepage/dialogs", method = RequestMethod.GET)
    public String allDialogs(Model model) throws Exception {
        List<Dialog> dialogs = messengerService.lookupDialogs(sessionUser.getUsername());
        model.addAttribute("dialogs", dialogs);
        return "Dialog/dialogpage";
    }

    @RequestMapping(value = "homepage/dialogs/{table_name}", method = RequestMethod.GET)
    public String concreteDialog(
            @PathVariable("table_name") String table_name
    ) throws Exception {
        if (table_name != null && !table_name.isEmpty())
            chosenDialog = messengerService.getDialog(table_name);
        return "redirect:/homepage/im/" + chosenDialog.getTableName();
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = (User) req.getSession().getAttribute("user");
//
//        List<Dialog> dialogs = user.getDialogs();
//
//        List<String> dialogNames = new ArrayList<>();
//
//        for (Dialog dialog: dialogs) {
//            dialogNames.add(dialog.getTableName());
//        }
//
//        String h = "Dialogs:";
//        if (dialogNames.isEmpty())
//            h = "No dialogs yet";
//
//        req.setAttribute("dialogNames", dialogNames);
//        req.setAttribute("h", h);
//        req.getRequestDispatcher("/jsp/Dialog/dialogpage.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }


}
