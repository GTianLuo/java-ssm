package com.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @RequestMapping(value = "/user/{pageNum}", method = RequestMethod.GET)
    public String selectUserList(Model model,@PathVariable Integer pageNum){
        System.out.println(pageNum);
        PageInfo page = userService.selectUserPage(pageNum);
        model.addAttribute("page",page);
        return "userList";
    }

    @RequestMapping(value = "/user/{pageNum}/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer pageNum,@PathVariable Integer id){
        userService.deleteUser(id);
        return "redirect:/user/" + pageNum;
    }
}
