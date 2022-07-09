package by.mensk.kitchen.service;

import by.mensk.kitchen.dto.bean.LoginInfo;
import by.mensk.kitchen.model.User;


public interface LoginService {
public boolean validateUser(LoginInfo info);
public String logoutUser();


}
