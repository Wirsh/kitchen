package by.mensk.kitchen.service;

import by.mensk.kitchen.dto.bean.LoginInfo;


public interface LoginService {
public boolean validateUser(LoginInfo info);
public String logoutUser();


}
