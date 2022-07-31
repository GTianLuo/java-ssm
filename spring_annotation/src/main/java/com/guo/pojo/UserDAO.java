package com.guo.pojo;


import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    public void saveUser(){
        System.out.println("用户信息保存成功！");
    }
}
