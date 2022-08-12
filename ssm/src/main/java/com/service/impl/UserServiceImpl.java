package com.service.impl;

import com.controller.UserController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mappers.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PageInfo<User> selectUserPage(Integer pageNum) {
        //开启分页插件
        PageHelper.startPage(pageNum,5);
        List<User> userList = userMapper.selectUserList();
        PageInfo<User> page = new PageInfo<>(userList,3);
        return page;
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
