package com.vk.kombarov_nikolay.web.homepage;

import com.vk.kombarov_nikolay.model.user.User;
import com.vk.kombarov_nikolay.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import java.sql.SQLException;

/**
 * Created by nikolaykombarov on 03.01.17.
 */

@Controller
@RequestMapping("/homepage")
public class Homepage extends HttpServlet {

    @Autowired
    private User sessionUser;

    @Autowired
    private UserService userService;

    @ModelAttribute("sessionUser")
    public User addSessionUserToModel() {
        return sessionUser;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String homepage() {
        return "redirect:/homepage/" + sessionUser.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String homePage(
            @PathVariable("username") String username,
            Model model
    ) throws SQLException {
        model.addAttribute("requestedUser", userService.getUser(username));
        return "Homepage/homepage";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify() {
        return "Homepage/modify";
    }

//    private static Logger logger;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        logger = Logger.getLogger(Homepage.class);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pageUsername = req.getParameter("username");
//        String clientUsername = req.getRemoteUser();
//
//        req.setAttribute("pageUsername", pageUsername);
//        req.setAttribute("clientUsername", clientUsername);
//        req.getRequestDispatcher("/jsp/Homepage/homepage.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
}
