package by.mensk.kitchen.mapper;

import by.mensk.kitchen.dto.bean.CreateUserBean;
import by.mensk.kitchen.dto.bean.UserBean;
import by.mensk.kitchen.model.User;

import java.util.Objects;

public class UserMapper {
    public UserBean userToUserBean(User user) {
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

    public User userBeanToUser(UserBean userBean) {
        return Objects.nonNull(userBean) ?
                User.builder()
                        .email(userBean.getEmail())
                        .userType(userBean.getUserType())
                        .pass(userBean.getPass())
                        .lastName(userBean.getLastName())
                        .name(userBean.getName())
                        .phone(userBean.getPhone())
                        .eventList(userBean.getEventList())
                        .build() : null;
    } //todo change all methods. do like this

    public User userBeanToUser(CreateUserBean newUser) {
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());
        user.setLastName(newUser.getLastName());
        user.setPass(newUser.getPass());
        user.setPhone(newUser.getPhone());
        return user;
    }

}
