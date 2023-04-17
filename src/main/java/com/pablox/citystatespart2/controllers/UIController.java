package com.pablox.citystatespart2.controllers;

import com.pablox.citystatespart2.models.LoginUser;
import com.pablox.citystatespart2.models.User;
import com.pablox.citystatespart2.services.StateService;
import com.pablox.citystatespart2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UIController {
    @Autowired
    private StateService stateService;
    @Autowired
    private UserService userService;

    // How it was...
//    @GetMapping("/")
//    public String Dashboard(Model model) {
//        model.addAttribute("states", stateService.getAll());
//        return "index.jsp";
//    }

    @GetMapping("/")
    public String Dashboard(Model model, HttpSession session, RedirectAttributes redirect) {
        if(session.getAttribute("userId") == null){
            redirect.addFlashAttribute("error", "Login to access content");
            return "redirect:/user/login";
        }
        User u = userService.getOne((Long) session.getAttribute("userId"));
        model.addAttribute("user", u);
        model.addAttribute("states", stateService.getAll());

        return "index.jsp";
    }
    @GetMapping("/user/register")
    public String UserRegister(@ModelAttribute("user") User user) {
        return "register.jsp";
    }
    // Login render route
    @GetMapping("/user/login")
    public String UserLogin(@ModelAttribute("loginUser") LoginUser loginUser) {
        return "login.jsp";
    }
}
