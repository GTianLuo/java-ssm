package com.guo.pojo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("qqq")
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void savaUser(){
        userDAO.saveUser();
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserService() {
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


}
