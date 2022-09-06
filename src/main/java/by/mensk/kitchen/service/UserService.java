package by.mensk.kitchen.service;

import by.mensk.kitchen.dto.bean.CreateUserBean;
import by.mensk.kitchen.enums.UserType;
import by.mensk.kitchen.model.User;

import java.util.List;


public interface UserService {
    User addUser(UserType type, String name, String lastName, Integer phone, String email);
    User addUser(String email,String pass);
    void deleteUser(Integer id);
    List<User> getAllUsers();
    User changeUserType(Integer id, UserType type);
    User updUser(User user,UserType type, String name, String lastName, Integer phone, String email);

    User getUser(Integer id);
    User getUser(String email);

    public User regUser(String emal, String pass);

     User addUser(CreateUserBean newUser);
}
