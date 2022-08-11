package com.controller;

import com.dao.EmployeeDao;
import com.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 在使用下面三个注解之前需要：1.导入Jackson依赖。2.开启mvc的注解驱动 <mvc:annotation-driven/>
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
 *
 * 3.RestController注解：符合注解，加在类上，相当于@Controller + 在每一个方法上加上@ResponseBody
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


    @RequestMapping("/down")
    public ResponseEntity<byte[]> down(HttpSession session) throws IOException {
        //获取文件的完整路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/img/shuo.jpg");
        System.out.println(realPath);
        //创建输入流
        FileInputStream fis = new FileInputStream(new File(realPath));
        //创建缓存流
        byte[] buffer= new byte[fis.available()];
        //从输入流读取数据
        fis.read(buffer);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字,attachment表示以附件的方式下载
        headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode("photo.jpg","UTF-8"));
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(buffer,headers,statusCode);
        return responseEntity;
    }

    @RequestMapping("/up")
    public void up(MultipartFile photo, HttpSession session, HttpServletResponse response) throws IOException {
        //检查上传文件是否有效
        if(photo.getSize() == 0){
            response.getWriter().write("<html><head> <meta charset=\"UTF-8\"></head><h1>请不要上传空文件！</h1></html>");
        }
        //获取源文件名
        String filename = photo.getOriginalFilename();
        //获取文件后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));
        //为文件获取一个不会重复的随机名
        filename = UUID.randomUUID().toString() + suffix;
        //获取服务器存放客户端上传图片的文件夹路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        System.out.println("photopath=" + photoPath);
        File file = new File(photoPath);
        //若文件夹不存在，那么创建该文件夹
        if(!file.exists()){
            file.mkdir();
        }
        //客户端上传图片存放的结对路径
        String path = photoPath + File.separator + filename;
        System.out.println("path = " + path);
        //上传图片
        photo.transferTo(new File(path));
        response.getWriter().write("<html><h1>Success！</h1></html>");
    }
}
