package by.mensk.kitchen.service.impl;

import by.mensk.kitchen.dto.bean.LoginInfo;
import by.mensk.kitchen.dto.bean.UserBean;
import by.mensk.kitchen.mapper.UserMapper;
import by.mensk.kitchen.model.User;
import by.mensk.kitchen.repository.UserRepository;
import by.mensk.kitchen.service.LoginService;
import by.mensk.kitchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static by.mensk.kitchen.util.Messages.GOODBYE_MESSAGE;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    public UserRepository userRepository;


    @Override
    public boolean validateUser(LoginInfo info) {
        UserMapper userMapper = new UserMapper();
        if(userRepository.findUserByEmail(info.getEmail())!=null) {
            UserBean userBean = userMapper.userToUserBean(userRepository.findUserByEmail(info.getEmail()));

         if (userBean.getPass().equals(info.getPass())) {
            return true;
        }}
        return false;

    }

    @Override
    public String logoutUser() {
       return GOODBYE_MESSAGE;
    }


}
