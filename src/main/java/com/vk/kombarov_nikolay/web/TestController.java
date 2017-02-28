package com.vk.kombarov_nikolay.web;

import com.vk.kombarov_nikolay.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nikolaykombarov on 13.02.17.
 */

@Controller
public class TestController {

    @Autowired
    public User user;

    @ModelAttribute("SessionUser")
    public User addSessionUserToModel() {
        return user;
    }

    @RequestMapping(value="/modelAttributes", method= RequestMethod.GET)
    public String getModelAttributeTest(Model model) {
        return "modelAttributeTest";
    }

}
