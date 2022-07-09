package by.mensk.kitchen.controller;

import by.mensk.kitchen.dto.bean.CreateUserBean;
import by.mensk.kitchen.dto.bean.LoginInfo;
import by.mensk.kitchen.mapper.UserMapper;
import by.mensk.kitchen.model.User;
import by.mensk.kitchen.service.LoginService;
import by.mensk.kitchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    public LoginService service;
    @Autowired
    public UserService userService;

    @GetMapping("/login")
    public String logInPage(Model model) {
        LoginInfo info = new LoginInfo();
        model.addAttribute("info", info);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(name = "loginInfo") LoginInfo info, Model m) {

        if (service.validateUser(info)) {
            m.addAttribute("info", info);
            User user = userService.getUser(info.getEmail());
            m.addAttribute("user", user);
            return "welcome";
        }

        m.addAttribute("error", "Incorrect Username & Password");
        return "error";
    }

    @GetMapping("/welcome")
    public String welcome(User user, Model model) {
        model.addAttribute("user", user);
        return "welcome";
    }


    @GetMapping("/logout")
    public String logout() {
        return service.logoutUser();
    }



    @GetMapping("/registration_form")
    public String regPage(Model model) {
        CreateUserBean newUser = new CreateUserBean();
        model.addAttribute("user", newUser);
        return "registration_form";

    }



}
