package com.pojo;

public class UserService {
    UserDAO userDAO;

    Integer id;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        System.out.println("通过setter注入");
        this.userDAO = userDAO;
    }

    public UserService(UserDAO userDAO,Integer id) {
        System.out.println("通过构造器注入！！！");
        this.userDAO = userDAO;
    }

    public UserService() {
    }

    public void saveUser(){
        userDAO.saveUser();
    }
}
