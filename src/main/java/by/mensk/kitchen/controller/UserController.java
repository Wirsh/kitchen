package by.mensk.kitchen.controller;

import by.mensk.kitchen.dto.bean.CreateUserBean;
import by.mensk.kitchen.dto.bean.LoginInfo;
import by.mensk.kitchen.model.User;
import by.mensk.kitchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add_user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user.userType, user.name, user.lastName, user.phone, user.email); //todo WTF?
        //todo send all object to addUser(user);
    }

    @GetMapping("/get_users_list")
    public List<User> users() {
        return userService.getAllUsers();

    }

    @PutMapping("/update_user{id}")
    public User updUser(@PathVariable(name = "id") Integer id) {
        User userToUpd = userService.getUser(id);
//      todo   return userService.updUser(userToUpd,);
        return null;

    }

//   todo @DeleteMapping("/delete_product/{id}")
//    public void deleteProduct(@PathVariable(name = "id") Integer id) {
//        productService.deleteProduct(id);


    @PostMapping("/reg_user")
    public String regUser(CreateUserBean newUser, Model model) {
        User user = userService.addUser(newUser);
        LoginInfo newLogin = new LoginInfo(newUser.getEmail(), newUser.getPass());
        model.addAttribute("info", newLogin);
        model.addAttribute("user", user);
        return "welcome";
    }
}

