package by.mensk.kitchen.service.impl;

import by.mensk.kitchen.dto.bean.CreateUserBean;
import by.mensk.kitchen.enums.UserType;
import by.mensk.kitchen.mapper.UserMapper;
import by.mensk.kitchen.model.User;
import by.mensk.kitchen.repository.UserRepository;
import by.mensk.kitchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(UserType type, String name, String lastName, Integer phone, String email) {
        User newUser = new User(type,name,lastName,phone,email);
        return repository.save(newUser);
    }

    @Override
    public User addUser(String email, String pass) {
        User newUser = new User(email,pass);
        return repository.save(newUser);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User changeUserType(Integer id, UserType type) {
        User userToUpd = repository.findById(id).get();
        userToUpd.setUserType(type);
        return repository.save(userToUpd);
    }



    @Override
    public User updUser(User user, UserType type, String name, String lastName, Integer phone, String email) {
        User userToUpdate = repository.findById(user.getId()).orElse(null);

        return userToUpdate;
    }

    @Override
    public User getUser(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getUser(String email) {
        return repository.findUserByEmail(email);
    }
    @Override
    public User regUser(String email, String pass) {
        User newUser = addUser(email,pass);
        return newUser;
    }

    @Override
    public User addUser(CreateUserBean newUser) {
        UserMapper userMapper = new UserMapper();
        User user = userMapper.userBeanToUser(newUser);
        User save = repository.save(user);
        return save;
    }
}
