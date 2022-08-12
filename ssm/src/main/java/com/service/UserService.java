package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.User;

import java.util.List;

public interface UserService {

    PageInfo<User> selectUserPage(Integer pageNum);

    void deleteUser(Integer id);
}
