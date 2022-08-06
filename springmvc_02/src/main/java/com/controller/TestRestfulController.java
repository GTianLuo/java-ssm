package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  查找全部User ： /user   ----->get
 *
 *  根据id查找User： /user/id  ------>get
 *
 *  添加用户信息：   /user     ------->post
 *
 *  修改用户信息：   /user/id    ------->put
 *
 *  删除用户信息：    /user/id   -------->delete
 */

@Controller
public class TestRestfulController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(Model model){
        model.addAttribute("operation","查找全部用户信息！");
        return "success";
    }

    @RequestMapping(value = "/user/{id}" ,method = RequestMethod.GET)
    public String getUserById(Model model,@PathVariable Integer id){
        model.addAttribute("operation","根据id查找用户信息！id为：" + id);
        return "success";
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public String addUser(Model model){
        model.addAttribute("operation","添加用户信息！");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String updateUser(Model model,@PathVariable Integer id){
        model.addAttribute("operation","更改用户信息!id为：" + id);
        return "success";
    }

    @RequestMapping(value = "/user/{id}" ,method = RequestMethod.DELETE)
    public String deleteUser(Model model,@PathVariable Integer id){
        model.addAttribute("operation","根据id删除用户信息！id为："+ id);
        return "success";
    }
}
