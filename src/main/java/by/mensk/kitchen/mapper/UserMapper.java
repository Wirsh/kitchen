package by.mensk.kitchen.mapper;

import by.mensk.kitchen.dto.bean.CreateUserBean;
import by.mensk.kitchen.dto.bean.UserBean;
import by.mensk.kitchen.model.User;

public class UserMapper {
   public UserBean userToUserBean(User user){
        UserBean userBean = new UserBean();
        userBean.setEmail(user.getEmail());
        userBean.setUserType(user.getUserType());
        userBean.setPass(user.getPass());
        userBean.setLastName(user.getLastName());
        userBean.setName(user.getName());
        userBean.setPhone(user.getPhone());
        userBean.setEventList(user.getEventList());


        return userBean;
    }
    public User userBeanToUser(UserBean userBean){
        User user = new User();
        user.setEmail(userBean.getEmail());
        user.setUserType(userBean.getUserType());
        user.setPass(userBean.getPass());
        user.setLastName(userBean.getLastName());
        user.setName(userBean.getName());
        user.setPhone(userBean.getPhone());
        user.setEventList(user.getEventList());


        return user;
    }
    public User userBeanToUser(CreateUserBean newUser) {
        User user = new User();
          user.setEmail(newUser.getEmail());
          user.setName(newUser.getName());
          user.setLastName(newUser.getLastName());
          user.setPass(newUser.getPass());
          user.setPhone(newUser.getPhone());
          return  user;
    }

}
