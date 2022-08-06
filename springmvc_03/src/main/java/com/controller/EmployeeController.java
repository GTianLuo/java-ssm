package com.controller;

import com.dao.EmployeeDao;
import com.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 在使用下面两个注解之前需要：1.导入Jackson依赖。2.开启mvc的注解驱动 <mvc:annotation-driven/>
 *
 * 1、RequestBody注解：获取请求体中的json格式数据，该数据我们同样是通过设置参数的方式获取，
 *   如果该json数据对应的有Java实体类我们就可以在控制方法参数中设置一个该类型参数，并且在参数的前面加上注解@RequestBody
 *   如果该json数据对应的没有Java实体类对象，我们可以在控制方法的参数中添加也该map集合来获取json对象，同样要加上注解。
 *
 * 2、ResponseBody注解：将json格式数据响应给浏览器，首先我们需要在控制器方法上加上注解ResponseBody注解，然后我们可以直接将想要转换为
 *    json字符串的Java对象作为控制器方法的返回值返回，下面是Jav对象和json字符串的对应关系
 *    java实体对象：json对象
 *    map集合：json对象
 *    list集合：json数组
 */


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employee")
    public String getAllEmployee(HttpSession session){
        Collection<Employee> employees = employeeDao.getAll();
        session.setAttribute("employees",employees);
        return "employees-list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "update";
    }

    @PutMapping("/employee")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping("/employee/delete/{id}")
    public String delete(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping("/ajax/axios")
    public void testGetJson(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello axios");
    }

    @RequestMapping("/ajax/responsebody")
    @ResponseBody
    public Map<String,Object> testPostJson(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("password","12345678");
        map.put("gender","男");
        map.put("age",19);
        return map;
    }
}
